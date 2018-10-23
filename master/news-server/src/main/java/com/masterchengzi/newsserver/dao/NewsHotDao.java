package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NewsFeedback;
import com.masterchengzi.newsserver.entity.NewsHot;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NewsHotDao {
	List<NewsHot> getNewsHot(String newsId, Date BeginDate,Date EndDate, String title ,String tag);

}