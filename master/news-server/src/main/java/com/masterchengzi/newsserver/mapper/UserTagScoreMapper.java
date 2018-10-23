package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.UserTagScore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserTagScoreMapper {
	List<UserTagScore> getUserTagScore(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserTagScore record);

	int update(UserTagScore record);
}