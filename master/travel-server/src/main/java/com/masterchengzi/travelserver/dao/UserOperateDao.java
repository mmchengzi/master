package com.masterchengzi.travelserver.dao;

import com.masterchengzi.travelserver.entity.UserOperate;

import java.util.Date;
import java.util.List;

public interface UserOperateDao {
    List<UserOperate> getList(String openId, Integer itemId,String partnerId,String version, Date beginTime ,Date endTime);
    int delete(String openId, Integer itemId,String version);
    int insert(UserOperate record);
    int update(UserOperate record);
}