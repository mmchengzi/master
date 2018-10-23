package com.masterchengzi.newsserver.controller;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsFeedback;
import com.masterchengzi.newsserver.service.NewsFeedbackService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * User zjc
 * Created with IntelliJ IDEA
 * Created on 2018-10-15 13:59
 */

@RestController
@Log
@RequestMapping("newsFeedback ")
@Api(value = "NewsFeedbackController ", description = "用户反馈")
public class NewsFeedbackController {
	@Autowired
	private NewsFeedbackService newsFeedbackService;

	/**
	 *
	 * @param userId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@ApiOperation(value = "获取列表")
	@GetMapping("/getNewsComment")
	public JsonResult getNewsComment(@RequestParam(name = "userId", required=false) String userId,
									 @RequestParam(name = "beginDate", required=false) Date beginDate,
									 @RequestParam(name = "endDate", required=false) Date endDate) {
		return newsFeedbackService.getNewsFeedback(userId, beginDate, endDate);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("/delete")
	public JsonResult delete(@RequestParam(name = "userId") String userId) {
		return newsFeedbackService.delete(userId);
	}

	@ApiOperation(value = "新增")
	@PostMapping("/insert")
	public JsonResult insert(@ApiParam(value = "NewsFeedback ") @RequestBody NewsFeedback record, HttpServletRequest request) {
		return newsFeedbackService.insert(record);
	}

	@ApiOperation(value = "修改")
	@PostMapping("/update")
	public JsonResult update(@ApiParam(value = "NewsFeedback ") @RequestBody NewsFeedback record, HttpServletRequest request) {
		return newsFeedbackService.update(record);
	}
}
