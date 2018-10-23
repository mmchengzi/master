package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.UserOperateDao;
import com.masterchengzi.newsserver.entity.UserOperate;
import com.masterchengzi.newsserver.mapper.UserOperateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserOperateDaoImpl implements UserOperateDao {
	@Autowired
	private UserOperateMapper userOperateMapper;
	@Override
	public List<UserOperate> getUserOperate(String userId, String newsId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("newsId", newsId);
		return userOperateMapper.getUserOperate(map);
	}

	@Override
	public int delete(String userId, String newsId) {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("newsId", newsId);
		return userOperateMapper.delete(map);
	}

	@Override
	public int insert(UserOperate record) {
		return userOperateMapper.insert(record);

	}

	@Override
	public int update(UserOperate record) {
		return userOperateMapper.update(record);
	}
}
