package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.UserMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserMessDao {
	List<UserMess> getUserMess(String userId);

	int delete(String userId);

	int insert(UserMess record);

	int update(UserMess record);
}