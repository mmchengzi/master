package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.NewsTagDeep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsTagDeepMapper {
	List<NewsTagDeep> getNewsTagDeep(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(NewsTagDeep record);

	int update(NewsTagDeep record);
}