package com.masterchengzi.newsgetserver.server.impl;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsgetserver.server.GetNewsFeign;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class HystrixClientFallback implements GetNewsFeign {
	@Override
	public JsonResult delete(String newsId, String keyword, String tag, Integer isOld, Date beginDate, Date endDate) {
		return new JsonResult(ResultCode.EXCEPTION, "feign_exception_callback: function delete is fail ! ");
	}

	@Override
	public JsonResult insert(List<GetNewsWithBLOBs> record) {
		return new JsonResult(ResultCode.EXCEPTION, "feign_exception_callback: function insert is fail ! ");
	}

	@Override
	public JsonResult getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate) {
		return new JsonResult(ResultCode.EXCEPTION, "feign_exception_callback: function getGetNews is fail ! ");
	}
}
