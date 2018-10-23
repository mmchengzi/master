package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface PrivilegeService {

	JsonResult getList(String role_id, String menu_id);

	JsonResult delete(String role_id, String menu_id);

	JsonResult insert(PrivilegeKey record);

	JsonResult update(PrivilegeKey record);

}