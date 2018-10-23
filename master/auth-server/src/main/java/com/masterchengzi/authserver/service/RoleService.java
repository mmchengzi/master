package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.Role;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface RoleService {
	JsonResult getList(String id, String name);

	JsonResult delete(String id, String name);

	JsonResult insert(Role record);

	JsonResult update(Role record);

}