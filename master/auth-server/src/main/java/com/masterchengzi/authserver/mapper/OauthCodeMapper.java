package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthCode;

public interface OauthCodeMapper {
    int insert(OauthCode record);

    int insertSelective(OauthCode record);
}