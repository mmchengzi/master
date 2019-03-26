package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;

import java.util.Date;
import java.util.List;

public interface GetNewsService {
	JsonResult getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, String beginDate, String endDate);
	JsonResult getPageNews(String newsId, String title, String keyword, String tag, Integer isOld, String beginDate, String endDate,Integer pageNum, Integer pageSize);

	JsonResult delete(String newsId,  String keyword, String tag, Integer isOld, String beginDate, String endDate);

	JsonResult insert(List<GetNewsWithBLOBs> record);
	JsonResult update(List<GetNewsWithBLOBs> record);
}