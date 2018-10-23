package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.UserLoveTag;

import java.util.List;
import java.util.Map;

public interface UserLoveTagDao {
	List<UserLoveTag> getUserLoveTag(String userId);

	int delete(String userId);

	int insert(UserLoveTag record);

	int update(UserLoveTag record);
}