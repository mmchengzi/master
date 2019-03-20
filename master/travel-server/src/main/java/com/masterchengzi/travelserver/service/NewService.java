package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.New;

import java.util.Date;
import java.util.List;

public interface NewService {
    JsonResult getList(Integer newId,Integer parentId,String openId, Date beginTime, Date endTime);
    JsonResult getPage(Integer newId,Integer parentId,String openId, Date beginTime, Date endTime, Integer pageNum, Integer pageSize);
    JsonResult delete(Integer newId,Integer parentId,String openId);
    JsonResult insert(List<New> record);
    JsonResult update(List<New> record);
}