package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.NewsFeedback;
import com.masterchengzi.authserver.entity.NewsHot;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsHotMapper {
	List<NewsHot> getNewsHot(Map<String, Object> map);
}