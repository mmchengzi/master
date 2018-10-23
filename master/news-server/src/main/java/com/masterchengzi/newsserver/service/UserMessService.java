package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserMess;

public interface UserMessService {
	JsonResult getUserMess(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserMess record);

	JsonResult update(UserMess record);
}