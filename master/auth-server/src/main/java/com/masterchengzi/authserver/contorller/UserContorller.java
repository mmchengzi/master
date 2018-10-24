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
@RequestMapping("User")
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

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "User") @RequestBody MyUser record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "User") @RequestBody MyUser record, HttpServletRequest request) {
		return service.update(record);
	}
}
