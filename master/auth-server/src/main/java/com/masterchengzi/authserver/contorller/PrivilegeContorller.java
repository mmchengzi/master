package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthRefreshToken;
import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.authserver.service.OauthRefreshTokenService;
import com.masterchengzi.authserver.service.PrivilegeService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("Privilege ")
@Api(value = "PrivilegeContorller ", description = "权限")
public class PrivilegeContorller {
	@Autowired
	private PrivilegeService service;

	/**
	 *
	 * @param role_id
	 * @param menu_id
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "role_id", required = false) String role_id,
			@RequestParam(name = "menu_id", required = false) String menu_id) {
		return service.getList(role_id, menu_id);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "role_id", required = false) String role_id,
							 @RequestParam(name = "menu_id", required = false) String menu_id) {
		return service.delete(role_id, menu_id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "PrivilegeKey ") @RequestBody PrivilegeKey record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "PrivilegeKey ") @RequestBody PrivilegeKey record, HttpServletRequest request) {
		return service.update(record);
	}
}
