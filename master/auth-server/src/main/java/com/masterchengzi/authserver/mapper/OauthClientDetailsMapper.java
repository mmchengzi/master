package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthClientDetails;

public interface OauthClientDetailsMapper {
    int deleteByPrimaryKey(String clientId);

    int insert(OauthClientDetails record);

    int insertSelective(OauthClientDetails record);

    OauthClientDetails selectByPrimaryKey(String clientId);

    int updateByPrimaryKeySelective(OauthClientDetails record);

    int updateByPrimaryKey(OauthClientDetails record);
}