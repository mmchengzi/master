package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.UserOperate;

public interface UserOperateService {
	JsonResult getUserOperate(String userId, String newsId);

	JsonResult delete(String userId, String newsId);

	JsonResult insert(UserOperate record);

	JsonResult update(UserOperate record);
}