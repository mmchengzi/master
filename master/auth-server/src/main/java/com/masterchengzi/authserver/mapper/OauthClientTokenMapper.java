package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthClientToken;

public interface OauthClientTokenMapper {
    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);

    OauthClientToken selectByPrimaryKey(String authenticationId);

    int updateByPrimaryKeySelective(OauthClientToken record);

    int updateByPrimaryKeyWithBLOBs(OauthClientToken record);

    int updateByPrimaryKey(OauthClientToken record);
}