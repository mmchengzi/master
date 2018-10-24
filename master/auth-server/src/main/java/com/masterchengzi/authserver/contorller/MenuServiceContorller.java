package com.masterchengzi.authserver.contorller;

import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.Menu;
import com.masterchengzi.authserver.service.MenuService;
import com.masterchengzi.authserver.service.impl.MyClientDetailsServiceImpl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("MenuService")
@Api(value = "MenuServiceContorller", description = "菜单")
public class MenuServiceContorller {
	@Autowired
	private MenuService service;

	/**
	 *
	 * @param id
	 * @param code
	 * @param p_code
	 * @param p_id
	 * @param name
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(name = "id", required = false) String id,
							  @RequestParam(name = "code", required = false) String code,
							  @RequestParam(name = "p_code", required = false) String p_code,
							  @RequestParam(name = "p_id", required = false) String p_id,
								@RequestParam(name = "name", required = false) String name) {
		return service.getList(id, code, p_code, p_id, name);
	}
	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "id", required = false) String id) {
		return service.delete(id);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "Menu") @RequestBody Menu record, HttpServletRequest request) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "Menu ") @RequestBody Menu record, HttpServletRequest request) {
		return service.update(record);
	}
}
