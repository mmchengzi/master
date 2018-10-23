package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.GetNewsDao;
import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import com.masterchengzi.newsserver.mapper.GetNewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GetNewsDaoImpl implements GetNewsDao {
	@Autowired
	GetNewsMapper getNewsMapper;

	@Override
	public List<GetNewsWithBLOBs> getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate,Date endDate) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		map.put("title", title);
		map.put("keyword", keyword);
		map.put("tag", tag);
		map.put("isOld", isOld);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return getNewsMapper.getGetNews(map);
	}

	@Override
	public int delete(String newsId) {
		Map map = new HashMap();
		map.put("newsId", newsId);
		return getNewsMapper.delete(map);
	}

	@Override
	public int insert(GetNewsWithBLOBs record) {
		return getNewsMapper.insert(record);
	}
	@Override
	public int update(GetNewsWithBLOBs record) {
		return getNewsMapper.update(record);
	}
}
