package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface UserService {
	JsonResult getList(String id, String username);

	JsonResult delete(String id, String username);

	JsonResult insert(MyUser record);

	JsonResult update(MyUser record);
}