package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.User;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface UserService {
	JsonResult getList(String id, String user_id);

	JsonResult delete(String id, String user_id);

	JsonResult insert(User record);

	JsonResult update(User record);
}