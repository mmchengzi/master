package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;

import java.util.Map;

public interface NotityService {

	JsonResult notityEmail(Map<String, String> map);

	JsonResult notitySMS(Map<String, String> map);
}