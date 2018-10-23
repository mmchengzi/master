package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserLoveTag;

public interface UserLoveTagService {
	JsonResult getUserLoveTag(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserLoveTag record);

	JsonResult update(UserLoveTag record);
}