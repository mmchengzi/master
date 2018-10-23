package com.masterchengzi.authserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserTagDeep;
import com.masterchengzi.authserver.service.UserTagDeepService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-10-15 13:59
 */

@RestController
@Log
@RequestMapping("UserTagDeep")
@Api(value = "UserTagDeepController", description = "用户标签因子喜欢程度")
public class UserTagDeepController {
	@Autowired
	private UserTagDeepService userTagDeepService;

	/**
	 *
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getUser")
	public JsonResult getUser(@RequestParam(name = "userId", required=false) String userId) {
		return userTagDeepService.getUserTagDeep(userId);
	}


	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId) {
		return userTagDeepService.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "UserTagDeep ") @RequestBody UserTagDeep record, HttpServletRequest request) {
		return userTagDeepService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "UserTagDeep ") @RequestBody UserTagDeep record, HttpServletRequest request) {
		return userTagDeepService.update(record);
	}
}
