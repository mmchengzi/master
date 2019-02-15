package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import com.masterchengzi.travelserver.dao.ItemDao;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao dao;
	@Override
	public JsonResult getList(Integer itemId, String itemName,String type, Date beginTime, Date endTime) {
		try {
			List<Item> resultList = dao.getList(itemId,itemName, type, beginTime, endTime);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(Integer itemId, String itemName,String type, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<Item> resultList = dao.getList(itemId,itemName ,type, beginTime, endTime);
			PageInfo<Item> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(Integer itemId) {
		try {
			Integer resultList = dao.delete(itemId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(List<Item> record) {
		try {
			int ret = 0;
			SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
			if (record != null && record.size() > 0) {
				for (Item dto : record) {
					List<Item> rlt = dao.getList(null,dto.getItemName(),dto.getType(),dto.getBeginTime(),dto.getEndTime());
					if (rlt != null && rlt.size() > 0) continue;
					dto.setItemId((int) idWorker.nextId());
					int r = dao.insert(dto);
					if (r >= 0) ret += r;
				}
			}
			JsonResult rlt = new JsonResult(ResultCode.SUCCESS, "成功", ret);
			return rlt;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(List<Item> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (Item dto : record) {
					int r = dao.update(dto);
					if (r >= 0) ret += r;
				}
			}
			return new JsonResult(ResultCode.SUCCESS, "成功", ret);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
