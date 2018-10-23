package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthRefreshToken;

public interface OauthRefreshTokenMapper {
    int insert(OauthRefreshToken record);

    int insertSelective(OauthRefreshToken record);
}