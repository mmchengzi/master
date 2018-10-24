package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthCode;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthCodeService {
	JsonResult getList(String code);

	JsonResult delete(String code);

	JsonResult insert(OauthCode record);
}