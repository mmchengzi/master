package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.UserMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserMessDao {
	List<UserMess> getUserMess(String userId);

	int delete(String userId);

	int insert(UserMess record);

	int update(UserMess record);
}