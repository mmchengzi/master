package com.masterchengzi.travelserver.dao;

import com.masterchengzi.travelserver.entity.Item;

import java.util.Date;
import java.util.List;

public interface ItemDao {
    List<Item> getList(Integer itemId, String itemName,Integer parentId,String type, Date beginTime,Date endTime);
    int delete(Integer itemId);
    int insert(Item record);
    int update(Item record);
}