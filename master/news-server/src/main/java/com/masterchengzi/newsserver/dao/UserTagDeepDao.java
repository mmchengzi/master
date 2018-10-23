package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.UserTagDeep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserTagDeepDao {
	List<UserTagDeep> getUserTagDeep(String userId);

	int delete(String userId);

	int insert(UserTagDeep record);

	int update(UserTagDeep record);
}