package com.masterchengzi.newsserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserOperate;
import com.masterchengzi.newsserver.service.UserOperateService;
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
@RequestMapping("UserOperate ")
@Api(value = "UserOperateController ", description = "用户操作")
public class UserOperateController {
	@Autowired
	private UserOperateService userOperateService;

	/**
	 *
	 * @param userId
	 * @param newsId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getUserOperate")
	public JsonResult getUserOperate(@RequestParam(name = "userId", required=false) String userId,
									 @RequestParam(name = "newsId", required=false) String newsId) {
		return userOperateService.getUserOperate(userId,newsId);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId,
							 @RequestParam(name = "newsId") String newsId) {
		return userOperateService.delete(userId,newsId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "UserOperate ") @RequestBody UserOperate record, HttpServletRequest request) {
		return userOperateService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "UserOperate ") @RequestBody UserOperate record, HttpServletRequest request) {
		return userOperateService.update(record);
	}
}
