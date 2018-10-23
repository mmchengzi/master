package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.NewsFeedback;
import com.masterchengzi.authserver.entity.NewsHot;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NewsHotDao {
	List<NewsHot> getNewsHot(String newsId, Date BeginDate,Date EndDate, String title ,String tag);

}