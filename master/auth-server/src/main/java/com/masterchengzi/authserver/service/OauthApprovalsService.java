package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthApprovals;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface OauthApprovalsService {

	JsonResult getList(String userId, String clientId);

	JsonResult delete(String userId);

	JsonResult insert(OauthApprovals record);

	JsonResult update(OauthApprovals record);
}