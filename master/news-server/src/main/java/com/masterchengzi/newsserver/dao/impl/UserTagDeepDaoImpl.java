package com.masterchengzi.authserver.dao.impl;

import com.masterchengzi.authserver.dao.UserTagDeepDao;
import com.masterchengzi.authserver.entity.UserTagDeep;
import com.masterchengzi.authserver.mapper.UserTagDeepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserTagDeepDaoImpl implements UserTagDeepDao {
	@Autowired
	private UserTagDeepMapper userTagDeepMapper;
	@Override
	public List<UserTagDeep> getUserTagDeep(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userTagDeepMapper.getUserTagDeep(map);
	}

	@Override
	public int delete(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userTagDeepMapper.delete(map);
	}

	@Override
	public int insert(UserTagDeep record) {
		return userTagDeepMapper.insert(record);
	}

	@Override
	public int update(UserTagDeep record) {
		return userTagDeepMapper.update(record);
	}
}
