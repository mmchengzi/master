package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserLoveTagDao;
import com.masterchengzi.newsserver.entity.UserLoveTag;
import com.masterchengzi.newsserver.mapper.UserLoveTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserLoveTagDaoImpl implements UserLoveTagDao {
	@Autowired
	private UserLoveTagMapper userLoveTagMapper;
	@Override
	public List<UserLoveTag> getUserLoveTag(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userLoveTagMapper.getUserLoveTag(map);
	}

	@Override
	public int delete(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userLoveTagMapper.delete(map);
	}

	@Override
	public int insert(UserLoveTag record) {
		return userLoveTagMapper.insert(record);

	}

	@Override
	public int update(UserLoveTag record) {
		return userLoveTagMapper.update(record);
	}
}
