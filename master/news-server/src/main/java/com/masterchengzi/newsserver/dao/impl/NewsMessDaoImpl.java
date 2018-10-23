package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.NewsMessDao;
import com.masterchengzi.newsserver.entity.NewsMess;
import com.masterchengzi.newsserver.mapper.NewsMessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class NewsMessDaoImpl implements NewsMessDao {
	@Autowired
	private NewsMessMapper newsMessMapper;
	@Override
	public List<NewsMess> getNewsMess(String newsId, String tag) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		map.put("tag", tag);
		return newsMessMapper.getNewsMess(map);
	}

	@Override
	public int delete(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return newsMessMapper.delete(map);
	}

	@Override
	public int insert(NewsMess record) {
		return newsMessMapper.insert(record);
	}

	@Override
	public int update(NewsMess record) {
		return newsMessMapper.update(record);
	}
}
