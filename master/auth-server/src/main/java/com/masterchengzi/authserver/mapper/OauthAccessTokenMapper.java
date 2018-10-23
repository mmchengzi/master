package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.Menu;
import com.masterchengzi.authserver.model.OauthAccessToken;
import com.masterchengzi.authserver.model.OauthAccessTokenWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthAccessTokenMapper {
    List<OauthAccessTokenWithBLOBs> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthAccessTokenWithBLOBs record);

    int update(OauthAccessTokenWithBLOBs record);

}