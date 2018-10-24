package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.mastercommon.common.JsonResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface MyClientDetailsService {
	JsonResult getList(String appId,String resourceIds );

	JsonResult delete(String appId);

	JsonResult insert(ClientDetails record);

	JsonResult update(ClientDetails record);

}