package com.masterchengzi.travelserver.dao;

import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.New;

import java.util.Date;
import java.util.List;

public interface NewDao {
    List<New> getList(Integer newId,Integer parentId,String openId,String tag, Date beginTime, Date endTime);
    int delete(Integer newId,Integer parentId,String openId);
    int insert(New record);
    int update(New record);
}