package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserTagScore;

public interface UserTagScoreService {
	JsonResult getUserTagScore(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserTagScore record);

	JsonResult update(UserTagScore record);
}