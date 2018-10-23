package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.UserMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMessMapper {
	List<UserMess> getUserMess(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserMess record);

	int update(UserMess record);
}