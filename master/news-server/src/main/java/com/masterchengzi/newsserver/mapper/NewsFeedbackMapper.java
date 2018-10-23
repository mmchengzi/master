package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.NewsFeedback;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsFeedbackMapper {

	List<NewsFeedback> getNewsFeedback(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(NewsFeedback record);

	int update(NewsFeedback record);
}