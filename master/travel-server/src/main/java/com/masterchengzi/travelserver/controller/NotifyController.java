package com.masterchengzi.travelserver.controller;


import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.service.NotityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("notify")
@Api(value = "NotifyController", description = "通知")
public class NotifyController {
	@Autowired
	private NotityService service;


	@ApiOperation(value = "参加活动邮箱通知", notes = "所需参数：  \n"
			+ "emails：邮箱地址 多个逗号隔开  \n"
			+ "addr：地点 \n"
			+ "time：时间   \n")
	@PostMapping("/notityEmail")
	public JsonResult notityEmail(@ApiParam(value = "Map<String, String>")  @RequestBody Map<String, String> reqMap) {
		return service.notityEmail(reqMap);
	}
	@ApiOperation(value = "参加活动短信通知", notes = "所需参数：  \n"
			+ "phoneNums：电话 多个逗号隔开  \n"
			+ "addr：地点 \n"
			+ "time：时间   \n")
	@PostMapping("/notitySMS")
	public JsonResult notitySMS(@ApiParam(value = "Map<String, String>")@RequestBody Map<String, String> reqMap) {
		return service.notitySMS(reqMap);
	}
}
