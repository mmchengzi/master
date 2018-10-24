package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthClientDetails;
import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.authserver.service.OauthClientDetailsService;
import com.masterchengzi.authserver.service.OauthClientTokenService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthClientToken")
@Api(value = "OauthClientTokenContorller ", description = "客户端token")
public class OauthClientTokenContorller {
	@Autowired
	private OauthClientTokenService service;

	/**
	 *
	 * @param token_id
	 * @param authentication_id
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "token_id", required = false) String token_id,
							  @RequestParam(name = "authentication_id", required = false) String authentication_id) {
		return service.getList(token_id, authentication_id);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "token_id", required = false) String token_id,
							 @RequestParam(name = "authentication_id", required = false) String authentication_id) {
		return service.delete(token_id, authentication_id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthClientToken ") @RequestBody OauthClientToken record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "OauthClientToken ") @RequestBody OauthClientToken record, HttpServletRequest request) {
		return service.update(record);
	}
}
