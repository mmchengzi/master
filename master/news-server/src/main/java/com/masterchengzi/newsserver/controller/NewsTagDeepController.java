package com.masterchengzi.newsserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsTagDeep;
import com.masterchengzi.newsserver.service.NewsTagDeepService;
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
@RequestMapping("NewsTagDeep")
@Api(value = "NewsTagDeepController  ", description = "新闻标签因子表")
public class NewsTagDeepController {
	@Autowired
	private NewsTagDeepService newsTagDeepService;

	/**
	 *
	 * @param newsId
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getNewsTagDeep")
	public JsonResult getNewsTagDeep(@RequestParam(name = "newsId", required=false) String newsId) {
		return newsTagDeepService.getNewsTagDeep(newsId);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "newsId") String newsId) {
		return newsTagDeepService.delete(newsId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "NewsTagDeep ") @RequestBody NewsTagDeep  record, HttpServletRequest request) {
		return newsTagDeepService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "NewsTagDeep ") @RequestBody NewsTagDeep record, HttpServletRequest request) {
		return newsTagDeepService.update(record);
	}
}
