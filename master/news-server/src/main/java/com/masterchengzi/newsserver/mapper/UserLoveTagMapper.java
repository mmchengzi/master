package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.UserLoveTag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserLoveTagMapper {
	List<UserLoveTag> getUserLoveTag(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserLoveTag record);

	int update(UserLoveTag record);
}