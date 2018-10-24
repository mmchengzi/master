package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthAccessTokenWithBLOBs;
import com.masterchengzi.authserver.service.OauthAccessTokenService;
import com.masterchengzi.authserver.service.impl.MyClientDetailsServiceImpl;
import com.masterchengzi.authserver.service.impl.OauthAccessTokenServiceImpl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthAccessToken")
@Api(value = "OauthAccessTokenContorller ", description = "权限")
public class OauthAccessTokenContorller {
	@Autowired
	private OauthAccessTokenService service;

	/**
	 *
	 * @param token_id
	 * @param authentication_id
	 * @param user_name
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "token_id", required = false) String token_id,
							  @RequestParam(name = "authentication_id", required = false) String authentication_id,
								@RequestParam(name = "user_name", required = false) String user_name) {
		return service.getList(token_id, authentication_id, user_name);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "token_id", required = false) String token_id,
							 @RequestParam(name = "authentication_id", required = false) String authentication_id) {
		return service.delete(token_id, authentication_id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthAccessTokenWithBLOBs ") @RequestBody OauthAccessTokenWithBLOBs  record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "OauthAccessTokenWithBLOBs ") @RequestBody OauthAccessTokenWithBLOBs record, HttpServletRequest request) {
		return service.update(record);
	}
}
