package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserBehavior;

public interface UserBehaviorService {
	JsonResult getUserBehavior(String userId, String newsId, String newsTag);

	JsonResult delete(String userId, String newsId);

	JsonResult insert(UserBehavior record);

	JsonResult update(UserBehavior record);

}