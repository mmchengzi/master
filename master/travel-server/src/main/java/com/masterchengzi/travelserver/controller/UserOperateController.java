package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.entity.UserOperate;
import com.masterchengzi.travelserver.service.UserOperateService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("userOperate")
@Api(value = "UserOperateController", description = "用户活动")
public class UserOperateController {
	@Autowired
	private UserOperateService service;


	@ApiOperation(value = "查询列表用户活动")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(value = "userId", required = false) Integer userId,
							  @RequestParam(value = "itemId", required = false) Integer itemId,
							  @RequestParam(value = "beginTime", required = false) Date beginTime,
							  @RequestParam(value = "endTime", required = false) Date endTime) {
		return service.getList(userId, itemId, beginTime, endTime);
	}

	@ApiOperation(value = "分页查询用户活动")
	@GetMapping("/getPage")
	public JsonResult getPageNews(@RequestParam(value = "userId", required = false) Integer userId,
								  @RequestParam(value = "itemId", required = false) Integer itemId,
								  @RequestParam(value = "beginTime", required = false) Date beginTime,
								  @RequestParam(value = "endTime", required = false) Date endTime,
								  @RequestParam(name = "pageNum", required = false) int pageNum,
								  @RequestParam(name = "pageSize", required = false) int pageSize) {
		return service.getPage(userId, itemId, beginTime, endTime, pageNum, pageSize);
	}

	@ApiOperation(value = "删除用户活动")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "itemId") Integer itemId) {
		return service.delete(userId,itemId);
	}

	@ResponseBody
	@ApiOperation(value = "新增用户活动")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<UserOperate>") @RequestBody List<UserOperate> record) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改用户活动")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<UserOperate>") @RequestBody List<UserOperate> record) {
		return service.update(record);
	}
}
