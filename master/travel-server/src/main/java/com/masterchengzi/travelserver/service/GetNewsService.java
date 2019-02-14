package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;

import java.util.Date;
import java.util.List;

public interface GetNewsService {
	JsonResult getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate);
	JsonResult getPageNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate,Integer pageNum, Integer pageSize);

	JsonResult delete(String newsId,  String keyword, String tag, Integer isOld, Date beginDate, Date endDate);

	JsonResult insert(List<GetNewsWithBLOBs> record);
	JsonResult update(List<GetNewsWithBLOBs> record);
}