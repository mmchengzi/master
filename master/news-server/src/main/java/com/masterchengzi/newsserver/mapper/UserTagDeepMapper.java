package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.UserTagDeep;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserTagDeepMapper {
	List<UserTagDeep> getUserTagDeep(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserTagDeep record);

	int update(UserTagDeep record);
}