package com.masterchengzi.authserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.User;
import com.masterchengzi.authserver.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-10-15 13:59
 */

@RestController
@Log
@RequestMapping("User")
@Api(value = "UserController ", description = "用户")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 *
	 * @param userId
	 * @param name
	 * @param phone
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getUser")
	public JsonResult getUser(@RequestParam(name = "userId", required=false) String userId,
							  @RequestParam(name = "name", required=false) String name,
							  @RequestParam(name = "phone", required=false) String phone,
							  @RequestParam(name = "beginDate", required=false) Date beginDate,
							  @RequestParam(name = "endDate", required=false) Date endDate) {
		return userService.getUser(userId,name,phone,beginDate,endDate);
	}

	@ApiOperation(value = "分页获取列表")
	@GetMapping("/getPageUser")
	public JsonResult getPageUser(@RequestParam(name = "userId", required=false) String userId,
							  @RequestParam(name = "name", required=false) String name,
							  @RequestParam(name = "phone", required=false) String phone,
							  @RequestParam(name = "beginDate", required=false) Date beginDate,
							  @RequestParam(name = "endDate", required=false) Date endDate,
							  @RequestParam(name = "pageNum", required=false) Integer pageNum,
							  @RequestParam(name = "pageSize", required=false) Integer pageSize) {
		return userService.getPageUser(userId,name,phone,beginDate,endDate,pageNum,pageSize);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId,
							 @RequestParam(name = "name") String name,
							 @RequestParam(name = "phone") String phone) {
		return userService.delete(userId, name, phone);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "User") @RequestBody User record, HttpServletRequest request) {
		return userService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "User") @RequestBody User record, HttpServletRequest request) {
		return userService.update(record);
	}
}
