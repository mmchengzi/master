package com.masterchengzi.newsserver.mapper;

import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GetNewsMapper {
	List<GetNewsWithBLOBs> getGetNews(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(GetNewsWithBLOBs record);
	int update(GetNewsWithBLOBs record);
}