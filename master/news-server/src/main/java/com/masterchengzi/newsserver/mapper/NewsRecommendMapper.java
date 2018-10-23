package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.NewsRecommend;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsRecommendMapper {
	List<NewsRecommend> getNewsRecommend(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(NewsRecommend record);

	int update(NewsRecommend record);
}