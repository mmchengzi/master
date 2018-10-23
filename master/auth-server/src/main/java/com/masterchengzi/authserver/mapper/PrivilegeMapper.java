package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.Privilege;
import com.masterchengzi.authserver.model.PrivilegeKey;

public interface PrivilegeMapper {
    int deleteByPrimaryKey(PrivilegeKey key);

    int insert(Privilege record);

    int insertSelective(Privilege record);

    Privilege selectByPrimaryKey(PrivilegeKey key);

    int updateByPrimaryKeySelective(Privilege record);

    int updateByPrimaryKey(Privilege record);
}