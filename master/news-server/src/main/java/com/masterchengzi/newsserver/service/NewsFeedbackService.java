package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsFeedback;

import java.util.Date;

public interface NewsFeedbackService {

	JsonResult getNewsFeedback(String userId, Date beginDate, Date endDate);

	JsonResult delete(String userid);

	JsonResult insert(NewsFeedback record);

	JsonResult update(NewsFeedback record);
}