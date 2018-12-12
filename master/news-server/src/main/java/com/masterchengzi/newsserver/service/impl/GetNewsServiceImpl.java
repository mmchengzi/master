package com.masterchengzi.newsserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.masterchengzi.newsserver.dao.GetNewsDao;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import com.masterchengzi.newsserver.service.GetNewsService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.mastercommon.common.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GetNewsServiceImpl implements GetNewsService {
	@Autowired
	private GetNewsDao getNewsDao;

	@Override
	public JsonResult getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate) {
		try {
			List<GetNewsWithBLOBs> resultList = getNewsDao.getGetNews(newsId, title, keyword, tag, isOld, beginDate, endDate);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult getPageNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate, Integer pageNum, Integer pageSize) {
		try {
			PageHelper.startPage(pageNum, pageSize);
			List<GetNewsWithBLOBs> resultList = getNewsDao.getGetNews(newsId, title, keyword, tag, isOld, beginDate, endDate);
			PageInfo<GetNewsWithBLOBs> resultPage = new PageInfo<>(resultList);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultPage);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String newsId,  String keyword, String tag, Integer isOld, Date beginDate, Date endDate) {
		try {
			Integer resultList = getNewsDao.delete(newsId,keyword,tag,isOld,beginDate,endDate);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(List<GetNewsWithBLOBs> record) {
		try {
			int ret = 0;
			SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
			if (record != null && record.size() > 0) {
				for (GetNewsWithBLOBs dto : record) {
					List<GetNewsWithBLOBs> rlt = getNewsDao.getGetNews(null, dto.getTitle(), null, null, null, null, null);
					if (rlt != null && rlt.size() > 0) continue;
					dto.setNewsId(String.valueOf(idWorker.nextId()));
					int r = getNewsDao.insert(dto);
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
	public JsonResult update(List<GetNewsWithBLOBs> record) {
		try {
			int ret = 0;
			if (record != null && record.size() > 0) {
				for (GetNewsWithBLOBs dto : record) {
					int r = getNewsDao.update(dto);
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
