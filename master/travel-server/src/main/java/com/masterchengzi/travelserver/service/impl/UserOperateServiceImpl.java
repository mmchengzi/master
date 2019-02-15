package com.masterchengzi.travelserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.travelserver.dao.UserOperateDao;
import com.masterchengzi.travelserver.entity.UserOperate;
import com.masterchengzi.travelserver.service.UserOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserOperateServiceImpl implements UserOperateService {
	@Autowired
	private UserOperateDao dao;

	@Override
	public JsonResult getList(Integer userId, Integer itemId, Date beginTime, Date endTime) {
		try {
			List<UserOperate> resultList = dao.getList(userId, itemId, beginTime, endTime);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPage(Integer userId, Integer itemId, Date beginTime, Date endTime, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<UserOperate> resultList = dao.getList(userId, itemId, beginTime, endTime);
			PageInfo<UserOperate> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(Integer userId, Integer itemId) {
		try {
			Integer resultList = dao.delete(userId, itemId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(List<UserOperate> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (UserOperate dto : record) {
					List<UserOperate> rlt = dao.getList(dto.getUserId(), dto.getItemId(), null, null);
					if (rlt != null && rlt.size() > 0) continue;
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
	public JsonResult update(List<UserOperate> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (UserOperate dto : record) {
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
