package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthCode;
import com.masterchengzi.authserver.model.OauthRefreshToken;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthRefreshTokenMapper {

    List<OauthRefreshToken> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthRefreshToken record);

    int update(OauthRefreshToken record);
}