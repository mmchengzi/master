package com.masterchengzi.travelserver.dao;

import com.masterchengzi.travelserver.entity.UserOperate;

import java.util.Date;
import java.util.List;

public interface UserOperateDao {
    List<UserOperate> getList(Integer userId, Integer itemId, Date beginTime ,Date endTime);
    int delete(Integer userId, Integer itemId);
    int insert(UserOperate record);
    int update(UserOperate record);
}