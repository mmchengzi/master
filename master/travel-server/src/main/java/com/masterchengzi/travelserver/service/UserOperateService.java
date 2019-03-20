package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.UserOperate;

import java.util.Date;
import java.util.List;

public interface UserOperateService {
    JsonResult getList(String openId, Integer itemId,String partnerId,String version, Date beginTime, Date endTime);
    JsonResult getPage(String openId, Integer itemId,String partnerId,String version,Date beginTime, Date endTime, Integer pageNum, Integer pageSize);
    JsonResult delete(String openId, Integer itemId,String version);
    JsonResult insert(List<UserOperate> record);
    JsonResult update(List<UserOperate>record);
    JsonResult signUp(String openid,String sex, String itemId,String version);
    JsonResult getRedis(String key);
    JsonResult deleteRedis(String key);
}