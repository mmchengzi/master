package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthClientTokenService {
	JsonResult getList(String token_id, String authentication_id);

	JsonResult delete(String token_id, String authentication_id);

	JsonResult insert(OauthClientToken record);

	JsonResult update(OauthClientToken record);

}