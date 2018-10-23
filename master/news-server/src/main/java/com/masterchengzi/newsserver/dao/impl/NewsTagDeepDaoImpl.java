package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.NewsTagDeepDao;
import com.masterchengzi.newsserver.entity.NewsTagDeep;
import com.masterchengzi.newsserver.mapper.NewsTagDeepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsTagDeepDaoImpl implements NewsTagDeepDao {
	@Autowired
	private NewsTagDeepMapper newsTagDeepMapper;
	@Override
	public List<NewsTagDeep> getNewsTagDeep(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return newsTagDeepMapper.getNewsTagDeep(map);
	}

	@Override
	public int delete(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return newsTagDeepMapper.delete(map);
	}

	@Override
	public int insert(NewsTagDeep record) {
		return newsTagDeepMapper.insert(record);

	}

	@Override
	public int update(NewsTagDeep record) {
		return newsTagDeepMapper.update(record);

	}
}
