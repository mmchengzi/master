package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserBehavior;

public interface UserBehaviorService {
	JsonResult getUserBehavior(String userId, String newsId, String newsTag);

	JsonResult delete(String userId, String newsId);

	JsonResult insert(UserBehavior record);

	JsonResult update(UserBehavior record);

}