package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthRefreshToken;
import com.masterchengzi.authserver.model.Privilege;
import com.masterchengzi.authserver.model.PrivilegeKey;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface PrivilegeMapper {

    List<PrivilegeKey> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(PrivilegeKey record);

    int update(PrivilegeKey record);

}