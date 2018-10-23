package com.masterchengzi.authserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserTagScore;
import com.masterchengzi.authserver.service.UserTagScoreService;
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
@RequestMapping("UserTagScore")
@Api(value = "UserTagScoreController ", description = "用户标签因子分数")
public class UserTagScoreController {
	@Autowired
	private UserTagScoreService userTagScoreService;

	/**
	 *
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getUser")
	public JsonResult getUser(@RequestParam(name = "userId", required=false) String userId) {
		return userTagScoreService.getUserTagScore(userId);
	}


	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId) {
		return userTagScoreService.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "UserTagScore ") @RequestBody UserTagScore record, HttpServletRequest request) {
		return userTagScoreService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "UserTagScore ") @RequestBody UserTagScore record, HttpServletRequest request) {
		return userTagScoreService.update(record);
	}
}
