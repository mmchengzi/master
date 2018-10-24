package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.OauthApprovals;
import com.masterchengzi.authserver.model.OauthClientDetails;
import com.masterchengzi.authserver.service.OauthApprovalsService;
import com.masterchengzi.authserver.service.OauthClientDetailsService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("OauthClientDetails")
@Api(value = "OauthClientDetailsContorller ", description = "权限 客户端详情")
public class OauthClientDetailsContorller {
	@Autowired
	private OauthClientDetailsService service;

	/**
	 *
	 * @param client_id
	 * @param resource_ids
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "client_id", required = false) String client_id,
							  @RequestParam(name = "resource_ids", required = false) String resource_ids) {
		return service.getList(client_id, resource_ids);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "client_id", required = false) String client_id,
							 @RequestParam(name = "resource_ids", required = false) String resource_ids) {
		return service.delete(client_id, resource_ids);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "OauthClientDetails ") @RequestBody OauthClientDetails record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "OauthClientDetails ") @RequestBody OauthClientDetails record, HttpServletRequest request) {
		return service.update(record);
	}
}
