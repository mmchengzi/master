package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthAccessTokenWithBLOBs;
import com.masterchengzi.authserver.model.OauthApprovals;
import com.masterchengzi.authserver.service.OauthAccessTokenService;
import com.masterchengzi.authserver.service.OauthApprovalsService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthApprovals")
@Api(value = "OauthApprovalsContorller ", description = "权限批准")
public class OauthApprovalsContorller {
	@Autowired
	private OauthApprovalsService service;

	/**
	 *
 	 * @param userId
	 * @param clientId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "userId", required = false) String userId,
							  @RequestParam(name = "clientId", required = false) String clientId) {
		return service.getList(userId, clientId);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId", required = false) String userId) {
		return service.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthApprovals ") @RequestBody OauthApprovals  record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "OauthApprovals") @RequestBody OauthApprovals  record, HttpServletRequest request) {
		return service.update(record);
	}
}
