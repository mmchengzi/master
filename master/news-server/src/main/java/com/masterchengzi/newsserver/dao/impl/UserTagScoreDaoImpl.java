package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserTagScoreDao;
import com.masterchengzi.newsserver.entity.UserTagScore;
import com.masterchengzi.newsserver.mapper.UserTagDeepMapper;
import com.masterchengzi.newsserver.mapper.UserTagScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserTagScoreDaoImpl implements UserTagScoreDao {
	@Autowired
	private UserTagScoreMapper userTagScoreMapper;
	@Override
	public List<UserTagScore> getUserTagScore(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userTagScoreMapper.getUserTagScore(map);
	}

	@Override
	public int delete(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return userTagScoreMapper.delete(map);
	}

	@Override
	public int insert(UserTagScore record) {
		return userTagScoreMapper.insert(record);
	}

	@Override
	public int update(UserTagScore record) {
		return userTagScoreMapper.update(record);
	}
}
