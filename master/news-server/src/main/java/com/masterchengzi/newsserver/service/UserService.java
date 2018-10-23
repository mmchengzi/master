package com.masterchengzi.authserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.authserver.entity.User;

import java.util.Date;

public interface UserService {

	JsonResult getUser(String userId, String name, String phone, Date benginDate, Date endDate);
	JsonResult getPageUser(String userId, String name, String phone, Date benginDate, Date endDate,Integer pageNum, Integer pageSize);
	JsonResult delete(String userId, String name, String phone);

	JsonResult insert(User record);

	JsonResult update(User record);
}