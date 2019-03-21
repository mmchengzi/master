package com.masterchengzi.travelserver.mapper;

import com.masterchengzi.travelserver.entity.New;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface NewMapper {
	List<New> getList(Map<String, Object> map);
	int delete(Map<String, Object> map);
	int insert(New record);
	int update(New record);
}
