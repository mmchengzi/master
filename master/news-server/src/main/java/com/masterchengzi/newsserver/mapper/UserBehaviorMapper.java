package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.UserBehavior;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserBehaviorMapper {
	List<UserBehavior> getUserBehavior(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserBehavior record);

	int update(UserBehavior record);

}