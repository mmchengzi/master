package com.masterchengzi.travelserver.service;

import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.travelserver.entity.Item;

import java.util.Date;
import java.util.List;

public interface ItemService {
    JsonResult getList(Integer itemId,String itemName, String type, Date beginTime, Date endTime);
    JsonResult getPage(Integer itemId, String itemName, String type, Date beginTime, Date endTime, Integer pageNum, Integer pageSize);
    JsonResult delete(Integer itemId);
    JsonResult insert(List<Item> record);
    JsonResult update(List<Item> record);
}