package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthRefreshToken;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthRefreshTokenService {

	JsonResult getList(String token_id);

	JsonResult delete(String token_id);

	JsonResult insert(OauthRefreshToken record);

	JsonResult update(OauthRefreshToken record);
}