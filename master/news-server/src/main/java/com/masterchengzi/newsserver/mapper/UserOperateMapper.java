package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.UserOperate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserOperateMapper {
	List<UserOperate> getUserOperate(Map<String, Object> map);

	int delete(Map<String, Object> map);

	int insert(UserOperate record);

	int update(UserOperate record);
}