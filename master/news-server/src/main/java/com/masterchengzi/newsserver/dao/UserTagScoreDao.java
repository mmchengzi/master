package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.UserTagScore;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserTagScoreDao {
	List<UserTagScore> getUserTagScore(String userId);

	int delete(String userId);

	int insert(UserTagScore record);

	int update(UserTagScore record);
}