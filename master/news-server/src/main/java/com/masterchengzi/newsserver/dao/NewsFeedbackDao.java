package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NewsFeedback;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface NewsFeedbackDao {

	List<NewsFeedback> getNewsFeedback(String userId,Date beginDate, Date endDate);

	int delete(String userid);

	int insert(NewsFeedback record);

	int update(NewsFeedback record);
}