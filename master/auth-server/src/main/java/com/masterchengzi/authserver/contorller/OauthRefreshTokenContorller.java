package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.authserver.model.OauthCode;
import com.masterchengzi.authserver.model.OauthRefreshToken;
import com.masterchengzi.authserver.service.OauthCodeService;
import com.masterchengzi.authserver.service.OauthRefreshTokenService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthRefreshToken ")
@Api(value = "OauthRefreshTokenContorller ", description = "刷新令牌触发器")
public class OauthRefreshTokenContorller {
	@Autowired
	private OauthRefreshTokenService service;

	/**
	 *
	 * @param token_id
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "token_id", required = false) String token_id) {
		return service.getList(token_id);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "token_id", required = false) String token_id) {
		return service.delete(token_id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthRefreshToken ") @RequestBody OauthRefreshToken record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "OauthRefreshToken ") @RequestBody OauthRefreshToken  record, HttpServletRequest request) {
		return service.update(record);
	}
}
