package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("user")
@Api(value = "UserContorller ", description = "用户")
public class UserContorller {
	@Autowired
	private UserService service;

	/**
	 *
	 * @param id
	 * @param username
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "username", required = false) String username) {
		return service.getList(id, username);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "id", required = false) String id,
							 @RequestParam(name = "username", required = false) String username) {
		return service.delete(id, username);
	}

	@ApiOperation(value = "注册")
	@PostMapping("/register")
	public JsonResult register(@ApiParam(value = "MyUser") @RequestBody MyUser record, HttpServletRequest request) {
		return service.register(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "MyUser") @RequestBody MyUser record, HttpServletRequest request) {
		return service.update(record);
	}
/*	@ApiOperation(value = "登录")
	@PostMapping("/login")
	public JsonResult login(@RequestParam(name = "username") String username,
							@RequestParam(name = "password") String password) {
		return service.login(username,password);
	}

	@ApiOperation(value = "刷新密钥")
	@GetMapping("/refreshToken")
	public JsonResult refreshToken(@RequestHeader (name = "authorization") String authorization) {
		return service.refreshToken(authorization);
	}*/
}
