package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
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
	public JsonResult getList(@RequestParam(value = "openId", required = false) String openId,
							  @RequestParam(value = "itemId", required = false) Integer itemId,
							  @RequestParam(name = "partnerId", required = false) String partnerId,
							  @RequestParam(name = "version", required = false) String version,
							  @RequestParam(value = "beginTime", required = false) Date beginTime,
							  @RequestParam(value = "endTime", required = false) Date endTime) {
		return service.getList(openId, itemId, partnerId, version, beginTime, endTime);
	}

	@ApiOperation(value = "分页查询用户活动")
	@GetMapping("/getPage")
	public JsonResult getPageNews(@RequestParam(value = "openId", required = false) String openId,
								  @RequestParam(value = "itemId", required = false) Integer itemId,
								  @RequestParam(name = "partnerId", required = false) String partnerId,
								  @RequestParam(name = "version", required = false) String version,
								  @RequestParam(value = "beginTime", required = false) Date beginTime,
								  @RequestParam(value = "endTime", required = false) Date endTime,
								  @RequestParam(name = "pageNum", required = false) int pageNum,
								  @RequestParam(name = "pageSize", required = false) int pageSize) {
		return service.getPage(openId, itemId, partnerId, version, beginTime, endTime, pageNum, pageSize);
	}

	@ApiOperation(value = "删除用户活动")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "openId") String openId,
							 @RequestParam(name = "itemId") Integer itemId,
							 @RequestParam(name = "version") String version) {
		return service.delete(openId, itemId, version);
	}

	@ResponseBody
	@ApiOperation(value = "新增用户活动")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<UserOperate>") @RequestBody List<UserOperate> record) {
		return service.insert(record);
	}
	@ApiOperation(value = "活动报名")
	@GetMapping("/signUp")
	public JsonResult signUp(@RequestParam(value = "openid", required = false) String openid,
								  @RequestParam(value = "sex", required = false) String sex,
								  @RequestParam(name = "itemId", required = false) String itemId,
								  @RequestParam(name = "version", required = false) String version) {
		return service.signUp(openid, sex, itemId, version);
	}
	@ApiOperation(value = "修改用户活动")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<UserOperate>") @RequestBody List<UserOperate> record) {
		return service.update(record);
	}
	@ApiOperation(value = "redis 查询")
	@GetMapping("/getRedis")
	public JsonResult getRedis(@RequestParam(value = "key", required = false) String key) {
		return service.getRedis(key);
	}
	@ApiOperation(value = "deleteRedis 可以模糊匹配删除")
	@DeleteMapping("/deleteRedis")
	public JsonResult deleteRedis(@RequestParam(value = "key", required = false) String key){
		return service.deleteRedis(key);
	}
}
