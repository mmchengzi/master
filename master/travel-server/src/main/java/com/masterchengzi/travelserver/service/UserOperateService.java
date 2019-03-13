package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.UserOperate;

import java.util.Date;
import java.util.List;

public interface UserOperateService {
    JsonResult getList(Integer userId, Integer itemId,Integer partnerId,String version, Date beginTime, Date endTime);
    JsonResult getPage(Integer userId, Integer itemId, Integer partnerId,String version,Date beginTime, Date endTime, Integer pageNum, Integer pageSize);
    JsonResult delete(Integer userId, Integer itemId,String version);
    JsonResult insert(List<UserOperate> record);
    JsonResult update(List<UserOperate>record);
    JsonResult signUp(Integer userId,String sex, Integer itemId,String version);
}