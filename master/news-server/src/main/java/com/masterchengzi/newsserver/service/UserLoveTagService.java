package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserLoveTag;

public interface UserLoveTagService {
	JsonResult getUserLoveTag(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserLoveTag record);

	JsonResult update(UserLoveTag record);
}