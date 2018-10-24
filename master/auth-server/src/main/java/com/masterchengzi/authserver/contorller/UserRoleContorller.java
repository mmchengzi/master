package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.Role;
import com.masterchengzi.authserver.model.UserRole;
import com.masterchengzi.authserver.service.RoleService;
import com.masterchengzi.authserver.service.UserRoleService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("UserRole")
@Api(value = "UserRoleContorller ", description = "用户角色")
public class UserRoleContorller {
	@Autowired
	private UserRoleService service;

	/**
	 *
	 * @param id
	 * @param user_id
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "user_id", required = false) String user_id) {
		return service.getList(id, user_id);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "id", required = false) String id,
							 @RequestParam(name = "user_id", required = false) String user_id) {
		return service.delete(id, user_id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "UserRole ") @RequestBody UserRole record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "UserRole ") @RequestBody UserRole record, HttpServletRequest request) {
		return service.update(record);
	}
}
