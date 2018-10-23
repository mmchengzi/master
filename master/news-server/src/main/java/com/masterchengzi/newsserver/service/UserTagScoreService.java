package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserTagScore;

public interface UserTagScoreService {
	JsonResult getUserTagScore(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserTagScore record);

	JsonResult update(UserTagScore record);
}