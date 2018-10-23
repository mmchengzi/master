package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.NewsRecommend;

import java.util.List;
import java.util.Map;

public interface NewsRecommendDao {
	List<NewsRecommend> getNewsRecommend(String userId);

	int delete(String userId);

	int insert(NewsRecommend record);

	int update(NewsRecommend record);
}