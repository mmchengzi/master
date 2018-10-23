package com.masterchengzi.newsserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsserver.dao.NewsTagDeepDao;
import com.masterchengzi.newsserver.entity.NewsTagDeep;
import com.masterchengzi.newsserver.service.NewsTagDeepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsTagDeepServiceImpl implements NewsTagDeepService {
	@Autowired
	private NewsTagDeepDao newsTagDeepDao;

	@Override
	public JsonResult getNewsTagDeep(String newsId) {
		try {
			List<NewsTagDeep> resultList = newsTagDeepDao.getNewsTagDeep(newsId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String newsId) {
		try {
			Integer resultList = newsTagDeepDao.delete(newsId);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NewsTagDeep record) {
		try {
			Integer resultList = newsTagDeepDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(NewsTagDeep record) {
		try {
			Integer resultList = newsTagDeepDao.update(record);
			return new JsonResult(ResultCode.SUCCESS, "成功", resultList);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
