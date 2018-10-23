package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.ClientDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ClientDetailsMapper {
	List<ClientDetails> getList(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(ClientDetails record);

	int update(ClientDetails record);

}