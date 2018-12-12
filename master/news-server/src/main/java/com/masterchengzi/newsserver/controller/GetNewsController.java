package com.masterchengzi.newsserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import com.masterchengzi.newsserver.service.GetNewsService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-10-15 13:59
 */

@RestController
@Log
@RequestMapping("getNews")
@Api(value = "GetNewsController", description = "获取新闻")
public class GetNewsController {
	@Autowired
	private GetNewsService getNewsService;

	/**
	 * @param newsId
	 * @param title
	 * @param keyword
	 * @param tag
	 * @param isOld
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@ApiOperation(value = "查询新闻列表")
	@GetMapping("/getGetNews")
	public JsonResult getGetNews(@RequestParam(value="newsId", required=false) String newsId,
								 @RequestParam(value="title", required=false) String title,
								 @RequestParam(value="keyword", required=false) String keyword,
								 @RequestParam(value="tag", required=false) String tag,
								 @RequestParam(value="isOld", required=false) Integer isOld,
								 @RequestParam(value="beginDate", required=false)  Date beginDate,
								 @RequestParam(value="endDate", required=false) Date endDate) {
		return getNewsService.getGetNews(newsId, title, keyword, tag, isOld, beginDate, endDate);
	}

	@ApiOperation(value = "分页查询新闻")
	@GetMapping("/getPageNews")
	public JsonResult getPageNews(@RequestParam(value="newsId", required=false) String newsId,
								  @RequestParam(value="title", required=false) String title,
								  @RequestParam(value="keyword", required=false) String keyword,
								  @RequestParam(value="tag", required=false) String tag,
								  @RequestParam(value="isOld", required=false) Integer isOld,
								  @RequestParam(value="beginDate", required=false)  Date beginDate,
								  @RequestParam(value="endDate", required=false) Date endDate,
								  @RequestParam(name = "pageNum", required=false) int pageNum,
								  @RequestParam(name = "pageSize", required=false) int pageSize) {
		return getNewsService.getPageNews(newsId, title, keyword, tag, isOld, beginDate, endDate, pageNum, pageSize);
	}

	@ApiOperation(value = "删除新闻")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "newsId") String newsId,
							 @RequestParam(value="keyword", required=false) String keyword,
							 @RequestParam(value="tag", required=false) String tag,
							 @RequestParam(value="isOld", required=false) Integer isOld,
							 @RequestParam(value="beginDate", required=false)  Date beginDate,
							 @RequestParam(value="endDate", required=false) Date endDate) {
		return getNewsService.delete(newsId,keyword,tag,isOld,beginDate,endDate);
	}
	@ResponseBody
	@ApiOperation(value = "新增新闻")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "List<GetNewsWithBLOBs>") @RequestBody List<GetNewsWithBLOBs> record) {
		return getNewsService.insert(record);
	}

	@ApiOperation(value = "修改新闻")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "List<GetNewsWithBLOBs>") @RequestBody List<GetNewsWithBLOBs> record) {
		return getNewsService.update(record);
	}
}
