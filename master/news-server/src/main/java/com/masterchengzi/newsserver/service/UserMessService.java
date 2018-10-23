package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserMess;

public interface UserMessService {
	JsonResult getUserMess(String userId);

	JsonResult delete(String userId);

	JsonResult insert(UserMess record);

	JsonResult update(UserMess record);
}