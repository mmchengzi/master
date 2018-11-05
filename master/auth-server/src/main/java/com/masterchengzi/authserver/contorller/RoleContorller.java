package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.authserver.model.Role;
import com.masterchengzi.authserver.service.PrivilegeService;
import com.masterchengzi.authserver.service.RoleService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("Role")
@Api(value = "RoleContorller ", description = "角色")
public class RoleContorller {
	@Autowired
	private RoleService service;

	/**
	 *
	 * @param id
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "id", required = false) String id,
			@RequestParam(name = "name", required = false) String name ,HttpServletRequest request) {
		return service.getList(id, name);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "id", required = false) String id,
							 @RequestParam(name = "name", required = false) String name) {
		return service.delete(id, name);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "Role ") @RequestBody Role record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "Role ") @RequestBody Role record, HttpServletRequest request) {
		return service.update(record);
	}
}
