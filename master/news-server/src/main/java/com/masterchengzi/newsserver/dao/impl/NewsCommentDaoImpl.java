package com.masterchengzi.authserver.dao.impl;

import com.masterchengzi.authserver.dao.NewsCommentDao;
import com.masterchengzi.authserver.entity.NewsComment;
import com.masterchengzi.authserver.mapper.NewsCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewsCommentDaoImpl implements NewsCommentDao {
	@Autowired
	private NewsCommentMapper newsCommentMapper;

	@Override
	public List<NewsComment> getNewsComment(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return newsCommentMapper.getNewsComment(map);
	}

	@Override
	public int delete(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return newsCommentMapper.delete(map);
	}

	@Override
	public int insert(NewsComment record) {
		return newsCommentMapper.insert(record);
	}

	@Override
	public int update(NewsComment record) {
		return newsCommentMapper.update(record);
	}
}
