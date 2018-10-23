package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.User;
import com.masterchengzi.authserver.model.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserRoleMapper {
    List<UserRole> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(UserRole record);

    int update(UserRole record);
}