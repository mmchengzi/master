package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.NewsRecommendDao;
import com.masterchengzi.newsserver.entity.NewsRecommend;
import com.masterchengzi.newsserver.mapper.NewsRecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsRecommendDaoImpl implements NewsRecommendDao {
	@Autowired
	private NewsRecommendMapper newsRecommendMapper;
	@Override
	public List<NewsRecommend> getNewsRecommend(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return newsRecommendMapper.getNewsRecommend(map);
	}

	@Override
	public int delete(String userId) {
		Map map = new HashMap();
		map.put("userId", userId);
		return newsRecommendMapper.delete(map);
	}

	@Override
	public int insert(NewsRecommend record) {
		return newsRecommendMapper.insert(record);
	}

	@Override
	public int update(NewsRecommend record) {
		return newsRecommendMapper.update(record);

	}
}
