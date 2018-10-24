package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthAccessTokenWithBLOBs;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthAccessTokenService {
	JsonResult getList(String token_id, String authentication_id, String user_name);

	JsonResult delete(String token_id, String authentication_id);

	JsonResult insert(OauthAccessTokenWithBLOBs OauthAccessTokenWithBLOBs);

	JsonResult update(OauthAccessTokenWithBLOBs OauthAccessTokenWithBLOBs);

}