package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.authserver.model.OauthCode;
import com.masterchengzi.authserver.service.OauthClientTokenService;
import com.masterchengzi.authserver.service.OauthCodeService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthCode")
@Api(value = "OauthCodeContorller ", description = "权限编码")
public class OauthCodeContorller {
	@Autowired
	private OauthCodeService service;

	/**
	 *
	 * @param code
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "code", required = false) String code) {
		return service.getList(code);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "code", required = false) String code) {
		return service.delete(code);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthCode ") @RequestBody OauthCode record, HttpServletRequest request) {
		return service.insert(record);
	}
}
