package com.masterchengzi.travelserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.New;
import com.masterchengzi.travelserver.service.ItemService;
import com.masterchengzi.travelserver.service.NewService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("new")
@Api(value = "NewController", description = "用户评论表")
public class NewController {
	@Autowired
	private NewService service;


	@ApiOperation(value = "查询评论列表")
	@GetMapping("/getList")
	public JsonResult getList(@RequestParam(value = "newId", required = false) Integer newId,
							  @RequestParam(value = "parentId", required = false) Integer parentId,
							  @RequestParam(value = "openId", required = false) String openId,
							  @RequestParam(value = "tag", required = false) String tag,
							  @RequestParam(value = "beginTime", required = false) Date beginTime,
							  @RequestParam(value = "endTime", required = false) Date endTime) {
		return service.getList(newId, parentId,openId,tag, beginTime, endTime);
	}
	@ApiOperation(value = "分页查询评论")
	@GetMapping("/getPage")
	public JsonResult getPageNews(@RequestParam(value = "newId", required = false) Integer newId,
								  @RequestParam(value = "parentId", required = false) Integer parentId,
								  @RequestParam(value = "openId", required = false) String openId,
								  @RequestParam(value = "tag", required = false) String tag,
								  @RequestParam(value = "beginTime", required = false) Date beginTime,
								  @RequestParam(value = "endTime", required = false) Date endTime,
								  @RequestParam(name = "pageNum", required = false) int pageNum,
								  @RequestParam(name = "pageSize", required = false) int pageSize) {
		return service.getPage(newId, parentId,openId, tag,beginTime, endTime, pageNum, pageSize);
	}

	@ApiOperation(value = "删除评论")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(value = "newId", required = false) Integer newId,
							 @RequestParam(value = "parentId", required = false) Integer parentId,
							 @RequestParam(value = "openId", required = false) String openId) {
		return service.delete(newId, parentId,openId);
	}

	@ResponseBody
	@ApiOperation(value = "新增评论")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<New>") @RequestBody List<New> record) {
		return service.insert(record);
	}

	@ApiOperation(value = "修改评论")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<New>") @RequestBody List<New> record) {
		return service.update(record);
	}
}
