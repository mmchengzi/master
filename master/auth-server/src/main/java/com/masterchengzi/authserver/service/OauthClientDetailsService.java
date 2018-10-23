package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthClientDetails;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthClientDetailsService {
	JsonResult getList(String client_id, String resource_ids);

	JsonResult delete(String client_id, String resource_ids);

	JsonResult insert(OauthClientDetails record);

	JsonResult update(OauthClientDetails record);

}