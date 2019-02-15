package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.service.ItemService;
import com.masterchengzi.travelserver.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("user")
@Api(value = "UserController", description = "用户信息")
public class UserController {
	@Autowired
	private UserService service;


	@ApiOperation(value = "查询用户列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(value = "userId", required = false) Integer userId,
							  @RequestParam(value = "username", required = false) String username,
							  @RequestParam(value = "beginTime", required = false) Date beginTime,
							  @RequestParam(value = "endTime", required = false) Date endTime) {
		return service.getList(userId, username, beginTime, endTime);
	}

	@ApiOperation(value = "分页查询用户")
	@GetMapping("/getPage")
	public JsonResult getPageNews(@RequestParam(value = "userId", required = false) Integer userId,
								  @RequestParam(value = "username", required = false) String username,
								  @RequestParam(value = "beginTime", required = false) Date beginTime,
								  @RequestParam(value = "endTime", required = false) Date endTime,
								  @RequestParam(name = "pageNum", required = false) int pageNum,
								  @RequestParam(name = "pageSize", required = false) int pageSize) {
		return service.getPage(userId, username, beginTime, endTime ,pageNum, pageSize);
	}

	@ApiOperation(value = "删除用户")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") Integer userId) {
		return service.delete(userId);
	}

	@ResponseBody
	@ApiOperation(value = "新增用户")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<User>") @RequestBody List<User> record) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改用户")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<Item>") @RequestBody List<User> record) {
		return service.update(record);
	}
}