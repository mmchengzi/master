package com.masterchengzi.authserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.authserver.dao.NewsCommentDao;
import com.masterchengzi.authserver.entity.NewsComment;
import com.masterchengzi.authserver.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsCommentServiceImpl implements NewsCommentService {
	@Autowired
	private NewsCommentDao newsCommentDao;
	@Override
	public JsonResult getNewsComment(String newsId) {
		try {
			List<NewsComment> resultList= newsCommentDao.getNewsComment(newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String newsId) {
		try {
			Integer resultList= newsCommentDao.delete(newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NewsComment record) {
		try {
			Integer resultList= newsCommentDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(NewsComment record) {
		try {
			Integer resultList= newsCommentDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
