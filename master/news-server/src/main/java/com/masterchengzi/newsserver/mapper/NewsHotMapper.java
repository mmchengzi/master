package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.NewsFeedback;
import com.masterchengzi.newsserver.entity.NewsHot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsHotMapper {
	List<NewsHot> getNewsHot(Map<String, Object> map);
}