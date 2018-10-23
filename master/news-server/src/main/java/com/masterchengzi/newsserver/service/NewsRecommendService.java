package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.NewsRecommend;

public interface NewsRecommendService {
	JsonResult getNewsRecommend(String userId);

	JsonResult delete(String userId);

	JsonResult insert(NewsRecommend record);

	JsonResult update(NewsRecommend record);
}