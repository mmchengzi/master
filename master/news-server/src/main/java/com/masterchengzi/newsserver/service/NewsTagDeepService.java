package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsTagDeep;

public interface NewsTagDeepService {
	JsonResult getNewsTagDeep(String newsId);

	JsonResult delete(String newsId);

	JsonResult insert(NewsTagDeep record);

	JsonResult update(NewsTagDeep record);
}