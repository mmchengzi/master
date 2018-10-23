package com.masterchengzi.newsserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsserver.dao.UserLoveTagDao;
import com.masterchengzi.newsserver.entity.UserLoveTag;
import com.masterchengzi.newsserver.service.UserLoveTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoveTagServiceImpl implements UserLoveTagService {
	@Autowired
	private UserLoveTagDao userLoveTagDao;
	@Override
	public JsonResult getUserLoveTag(String userId) {
		try {
			List<UserLoveTag> resultList= userLoveTagDao.getUserLoveTag(userId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String userId) {
		try {
			Integer resultList= userLoveTagDao.delete(userId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(UserLoveTag record) {
		try {
			Integer resultList= userLoveTagDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(UserLoveTag record) {
		try {
			Integer resultList= userLoveTagDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
