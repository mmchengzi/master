package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    JsonResult getList(Integer userId, String username, Date beginTime, Date endTime);
    JsonResult getPage(Integer userId, String username, Date beginTime, Date endTime, Integer pageNum, Integer pageSize);
    JsonResult delete(Integer userId);
    JsonResult insert(List<User> record);
    JsonResult update(List<User> record);
}