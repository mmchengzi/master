package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.authserver.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface RoleMapper {
    List<Role> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(Role record);

    int update(Role record);

}