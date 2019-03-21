package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.service.ItemService;
import com.masterchengzi.travelserver.service.NotityService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("notify")
@Api(value = "NotifyController", description = "通知")
public class NotifyController {
	@Autowired
	private NotityService service;


	@ApiOperation(value = "参加活动邮箱通知")
	@PostMapping("/notityEmail")
	public JsonResult notityEmail(
			@ApiParam(value = "ArrayList<String>") @RequestBody ArrayList<String> emails,
			@ApiParam(value = "String") @RequestBody String content) {
		return service.notityEmail(emails, content);
	}

	@ApiOperation(value = "参加活动短信通知")
	@PostMapping("/notitySMS")
	public JsonResult notitySMS(
			@ApiParam(value = "ArrayList<String>") @RequestBody ArrayList<String> phoneNums,
	@ApiParam(value = "String") @RequestBody String content) {
		return service.notitySMS(phoneNums, content);
	}
}
