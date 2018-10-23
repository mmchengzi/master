package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.GetNewsWithBLOBs;
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