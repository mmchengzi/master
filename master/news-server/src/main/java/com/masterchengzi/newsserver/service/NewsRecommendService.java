package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsRecommend;

public interface NewsRecommendService {
	JsonResult getNewsRecommend(String userId);

	JsonResult delete(String userId);

	JsonResult insert(NewsRecommend record);

	JsonResult update(NewsRecommend record);
}