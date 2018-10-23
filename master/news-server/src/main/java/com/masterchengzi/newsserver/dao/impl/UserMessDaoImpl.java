package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserMessDao;
import com.masterchengzi.newsserver.entity.UserMess;
import com.masterchengzi.newsserver.mapper.UserMessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMessDaoImpl implements UserMessDao {
	@Autowired
	private UserMessMapper userMessMapper;
	@Override
	public List<UserMess> getUserMess(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userMessMapper.getUserMess(map);
	}

	@Override
	public int delete(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userMessMapper.delete(map);
	}

	@Override
	public int insert(UserMess record) {
	return userMessMapper.insert(record);
	}

	@Override
	public int update(UserMess record) {
		return userMessMapper.update(record);
	}
}
