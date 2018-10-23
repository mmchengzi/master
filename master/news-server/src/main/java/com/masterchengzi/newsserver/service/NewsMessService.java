package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.NewsMess;

public interface NewsMessService {
	JsonResult getNewsMess(String newsId, String tag);

	JsonResult delete(String newsId);

	JsonResult insert(NewsMess record);

	JsonResult update(NewsMess record);
}