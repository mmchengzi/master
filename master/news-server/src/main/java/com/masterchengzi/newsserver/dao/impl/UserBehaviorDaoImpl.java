package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserBehaviorDao;
import com.masterchengzi.newsserver.entity.UserBehavior;
import com.masterchengzi.newsserver.mapper.UserBehaviorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserBehaviorDaoImpl implements UserBehaviorDao {
	@Autowired
	private UserBehaviorMapper userBehaviorMapper;
	@Override
	public List<UserBehavior> getUserBehavior(String userId, String newsId, String newsTag) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("newsId", newsId);
		map.put("newsTag", newsTag);
		return userBehaviorMapper.getUserBehavior(map);

	}

	@Override
	public int delete(String userId, String newsId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("newsId", newsId);
		return userBehaviorMapper.delete(map);

	}

	@Override
	public int insert(UserBehavior record) {
		return userBehaviorMapper.insert(record);

	}

	@Override
	public int update(UserBehavior record) {
		return userBehaviorMapper.update(record);
	}
}
