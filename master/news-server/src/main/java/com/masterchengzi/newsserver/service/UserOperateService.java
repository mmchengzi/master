package com.masterchengzi.newsserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.newsserver.entity.UserOperate;

public interface UserOperateService {
	JsonResult getUserOperate(String userId, String newsId);

	JsonResult delete(String userId, String newsId);

	JsonResult insert(UserOperate record);

	JsonResult update(UserOperate record);
}