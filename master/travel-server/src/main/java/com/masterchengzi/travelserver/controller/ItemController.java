package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.service.ItemService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("item")
@Api(value = "ItemController", description = "活动项目")
public class ItemController {
	@Autowired
	private ItemService service;


	@ApiOperation(value = "查询活动项目列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(value = "itemId", required = false) Integer itemId,
							  @RequestParam(value = "itemName", required = false) String itemName,
							  @RequestParam(value = "parentId", required = false) Integer parentId,
							  @RequestParam(value = "type", required = false) String type,
							  @RequestParam(value = "beginTime", required = false) Date beginTime,
							  @RequestParam(value = "endTime", required = false) Date endTime) {
		return service.getList(itemId, itemName,  parentId,type, beginTime, endTime);
	}

	@ApiOperation(value = "分页查询活动项目")
	@GetMapping("/getPage")
	public JsonResult getPageNews(@RequestParam(value = "itemId", required = false) Integer itemId,
								  @RequestParam(value = "itemName", required = false) String itemName,
								  @RequestParam(value = "parentId", required = false) Integer parentId,
								  @RequestParam(value = "type", required = false) String type,
								  @RequestParam(value = "beginTime", required = false) Date beginTime,
								  @RequestParam(value = "endTime", required = false) Date endTime,
								  @RequestParam(name = "pageNum", required = false) int pageNum,
								  @RequestParam(name = "pageSize", required = false) int pageSize) {
		return service.getPage(itemId, itemName,parentId, type, beginTime, endTime, pageNum, pageSize);
	}

	@ApiOperation(value = "删除活动项目")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "itemId") Integer itemId) {
		return service.delete(itemId);
	}

	@ResponseBody
	@ApiOperation(value = "新增活动")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<Item>") @RequestBody List<Item> record) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改活动")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<Item>") @RequestBody List<Item> record) {
		return service.update(record);
	}
}
