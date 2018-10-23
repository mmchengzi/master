package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserTagDeep;

public interface UserTagDeepService {
	JsonResult getUserTagDeep(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserTagDeep record);

	JsonResult update(UserTagDeep record);
}