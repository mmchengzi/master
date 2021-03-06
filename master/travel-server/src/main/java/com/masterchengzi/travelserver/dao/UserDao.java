package com.masterchengzi.travelserver.dao;

import com.masterchengzi.travelserver.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {
    List<User> getList(Integer userId, String username,String openid,String email, String phone,Date beginTime,Date endTime);
    int delete(Integer userId,String openid);
    int insert(User record);
    int update(User record);
}