package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.NewsMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NewsMessMapper {
	List<NewsMess> getNewsMess(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(NewsMess record);

	int update(NewsMess record);
}