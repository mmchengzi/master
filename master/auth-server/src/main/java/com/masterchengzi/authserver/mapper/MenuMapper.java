package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuMapper {
	List<Menu> getList(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(Menu record);

	int update(Menu record);
}