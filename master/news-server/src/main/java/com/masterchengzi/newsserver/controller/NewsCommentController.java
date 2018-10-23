package com.masterchengzi.authserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsComment;
import com.masterchengzi.authserver.service.NewsCommentService;
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
@RequestMapping("NewsComment")
@Api(value = "NewsCommentController", description = "新闻评论")
public class NewsCommentController {
	@Autowired
	private NewsCommentService newsCommentService;

	/**
	 *
	 * @param newsId
	 * @return
	 */
	@ApiOperation(value = "获取新闻评论列表")
	@GetMapping("/getNewsComment")
	public JsonResult getNewsComment(@RequestParam(name = "newsId", required=false) String newsId) {
		return newsCommentService.getNewsComment(newsId);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "newsId") String newsId) {
		return newsCommentService.delete(newsId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "NewsComment ") @RequestBody NewsComment  record, HttpServletRequest request) {
		return newsCommentService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "NewsComment ") @RequestBody NewsComment record, HttpServletRequest request) {
		return newsCommentService.update(record);
	}
}
