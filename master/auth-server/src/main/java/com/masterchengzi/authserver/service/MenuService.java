package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.Menu;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface MenuService {
	JsonResult getList(String id, String code, String p_code, String p_id, String name);

	JsonResult delete(String id);

	JsonResult insert(Menu record);

	JsonResult update(Menu record);
}