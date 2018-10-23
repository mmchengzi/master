package com.masterchengzi.authserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsRecommend;
import com.masterchengzi.authserver.service.NewsRecommendService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-10-15 13:59
 */

@RestController
@Log
@RequestMapping("NewsRecommend")
@Api(value = "NewsRecommendController ", description = "用户推荐新闻表")
public class NewsRecommendController {
	@Autowired
	private NewsRecommendService newsRecommendService;

	/**
	 *
	 * @param userId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getNewsRecommend")
	public JsonResult getNewsRecommend(@RequestParam(name = "userId", required=false) String userId) {
		return newsRecommendService.getNewsRecommend(userId);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId) {
		return newsRecommendService.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "NewsRecommend ") @RequestBody NewsRecommend record, HttpServletRequest request) {
		return newsRecommendService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "NewsRecommend ") @RequestBody NewsRecommend record, HttpServletRequest request) {
		return newsRecommendService.update(record);
	}
}
