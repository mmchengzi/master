package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.UserBehavior;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserBehaviorDao {
	List<UserBehavior> getUserBehavior(String userId,String newsId, String newsTag);

	int delete(String userId,String newsId);

	int insert(UserBehavior record);

	int update(UserBehavior record);

}