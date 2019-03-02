package com.masterchengzi.travelserver.dao.impl;

import com.masterchengzi.travelserver.dao.UserDao;
import com.masterchengzi.travelserver.entity.User;
import com.masterchengzi.travelserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> getList(Integer userId, String username,String email,String phone, Date beginTime, Date endTime) {
        Map map = new HashMap();
        map.put("id", userId);
        map.put("username", username);
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        map.put("email", email);
        map.put("phone", phone);
        return mapper.getList(map);
    }

    @Override
    public int delete(Integer userId) {
        Map map = new HashMap();
        map.put("id", userId);
        return mapper.delete(map);
    }

    @Override
    public int insert(User record) {
        return mapper.insert(record);
    }

    @Override
    public int update(User record) {
        return mapper.update(record);
    }
}
