package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserTagDeep;

public interface UserTagDeepService {
	JsonResult getUserTagDeep(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserTagDeep record);

	JsonResult update(UserTagDeep record);
}