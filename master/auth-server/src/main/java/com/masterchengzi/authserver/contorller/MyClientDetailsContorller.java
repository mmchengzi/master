package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.service.MyClientDetailsService;
import com.masterchengzi.authserver.service.impl.MyClientDetailsServiceImpl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NAdmin;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("MyClientDetails")
@Api(value = "ClientDetailsContorller", description = "客户端信息")
public class MyClientDetailsContorller {
	@Autowired
	private MyClientDetailsService service;

	/**
	 *
	 * @param appId
	 * @param resourceIds
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "appId", required = false) String appId,
								@RequestParam(name = "resourceIds", required = false) String resourceIds) {
		return service.getList(appId, resourceIds);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "appId", required = false) String appId) {
		return service.delete(appId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "ClientDetails") @RequestBody ClientDetails record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "ClientDetails") @RequestBody ClientDetails record, HttpServletRequest request) {
		return service.update(record);
	}
}
