package com.masterchengzi.newsserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsserver.dao.UserBehaviorDao;
import com.masterchengzi.newsserver.entity.UserBehavior;
import com.masterchengzi.newsserver.service.UserBehaviorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBehaviorServiceImpl implements UserBehaviorService {
	@Autowired
	private UserBehaviorDao userBehaviorDao;
	@Override
	public JsonResult getUserBehavior(String userId, String newsId, String newsTag) {
		try {
			List<UserBehavior> resultList= userBehaviorDao.getUserBehavior(userId, newsId, newsTag);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String userId, String newsId) {
		try {
			Integer resultList= userBehaviorDao.delete( userId, newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(UserBehavior record) {
		try {
			Integer resultList= userBehaviorDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(UserBehavior record) {
		try {
			Integer resultList= userBehaviorDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
