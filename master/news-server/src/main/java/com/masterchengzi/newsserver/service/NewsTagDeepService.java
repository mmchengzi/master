package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsTagDeep;

public interface NewsTagDeepService {
	JsonResult getNewsTagDeep(String newsId);

	JsonResult delete(String newsId);

	JsonResult insert(NewsTagDeep record);

	JsonResult update(NewsTagDeep record);
}