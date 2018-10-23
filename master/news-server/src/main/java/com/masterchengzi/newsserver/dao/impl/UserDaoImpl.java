package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserDao;
import com.masterchengzi.newsserver.entity.User;
import com.masterchengzi.newsserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUser(String userId, String name, String phone, Date benginDate,Date endDate) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("name", name);
		map.put("phone", phone);
		map.put("benginDate", benginDate);
		map.put("endDate", endDate);
		return userMapper.getUser(map);
	}

	@Override
	public int delete(String userId, String name, String phone) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("name", name);
		map.put("phone", phone);
		return userMapper.delete(map);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int update(User record) {
		return userMapper.update(record);
	}
}
