package com.masterchengzi.newsserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserLoveTag;
import com.masterchengzi.newsserver.service.UserLoveTagService;
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
@RequestMapping("UserLoveTag")
@Api(value = "UserLoveTagController ", description = "用户标签")
public class UserLoveTagController {
	@Autowired
	private UserLoveTagService userLoveTagService;

	/**
	 *
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getUserLoveTag")
	public JsonResult getUserLoveTag(@RequestParam(name = "userId", required=false) String userId) {
		return userLoveTagService.getUserLoveTag(userId);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId) {
		return userLoveTagService.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "UserLoveTag ") @RequestBody UserLoveTag record, HttpServletRequest request) {
		return userLoveTagService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "UserLoveTag ") @RequestBody UserLoveTag record, HttpServletRequest request) {
		return userLoveTagService.update(record);
	}
}
