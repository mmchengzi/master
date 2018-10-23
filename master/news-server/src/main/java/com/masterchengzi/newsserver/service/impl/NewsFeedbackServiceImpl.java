package com.masterchengzi.authserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.authserver.dao.NewsFeedbackDao;
import com.masterchengzi.authserver.entity.NewsFeedback;
import com.masterchengzi.authserver.service.NewsFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsFeedbackServiceImpl implements NewsFeedbackService {
	@Autowired
	private NewsFeedbackDao newsFeedbackDao;
	@Override
	public JsonResult getNewsFeedback(String userId, Date beginDate, Date endDate) {
		try {
			List<NewsFeedback> resultList= newsFeedbackDao.getNewsFeedback(userId,beginDate,endDate);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String userid) {
		try {
			Integer resultList= newsFeedbackDao.delete(userid);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NewsFeedback record) {
		try {
			Integer resultList= newsFeedbackDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(NewsFeedback record) {
		try {
			Integer resultList= newsFeedbackDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
