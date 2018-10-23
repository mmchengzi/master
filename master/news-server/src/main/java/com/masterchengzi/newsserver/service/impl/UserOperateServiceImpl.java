package com.masterchengzi.authserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.authserver.dao.UserOperateDao;
import com.masterchengzi.authserver.entity.UserOperate;
import com.masterchengzi.authserver.service.UserOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOperateServiceImpl implements UserOperateService {
	@Autowired
	private UserOperateDao userOperateDao;
	@Override
	public JsonResult getUserOperate(String userId, String newsId) {
		try {
			List<UserOperate> resultList= userOperateDao.getUserOperate(userId, newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String userId, String newsId) {
		try {
			Integer resultList= userOperateDao.delete(userId, newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(UserOperate record) {
		try {
			Integer resultList= userOperateDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(UserOperate record) {
		try {
			Integer resultList= userOperateDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
