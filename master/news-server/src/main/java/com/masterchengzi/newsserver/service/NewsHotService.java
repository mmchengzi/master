package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;

import java.util.Date;

public interface NewsHotService {
	JsonResult getNewsHot(String newsId, Date BeginDate, Date EndDate, String title, String tag);

}