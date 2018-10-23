package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.UserRole;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface UserRoleService {
	JsonResult getList(String id, String username, String name);

	JsonResult delete(String id);

	JsonResult insert(UserRole record);

	JsonResult update(UserRole record);
}