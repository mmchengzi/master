package com.masterchengzi.newsserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsserver.dao.NewsRecommendDao;
import com.masterchengzi.newsserver.entity.NewsRecommend;
import com.masterchengzi.newsserver.service.NewsRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsRecommendServiceImpl implements NewsRecommendService {
	@Autowired
	private NewsRecommendDao newsRecommendDao;

	@Override
	public JsonResult getNewsRecommend(String userId) {
		try {
			List<NewsRecommend> resultList = newsRecommendDao.getNewsRecommend(userId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String userId) {
		try {
			Integer resultList = newsRecommendDao.delete(userId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NewsRecommend record) {
		try {
			Integer resultList = newsRecommendDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(NewsRecommend record) {
		try {
			Integer resultList = newsRecommendDao.update(record);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
