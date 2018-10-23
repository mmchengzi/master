package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NewsRecommend;

import java.util.List;
import java.util.Map;

public interface NewsRecommendDao {
	List<NewsRecommend> getNewsRecommend(String userId);

	int delete(String userId);

	int insert(NewsRecommend record);

	int update(NewsRecommend record);
}