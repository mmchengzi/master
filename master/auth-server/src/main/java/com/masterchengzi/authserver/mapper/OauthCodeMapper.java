package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.authserver.model.OauthCode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthCodeMapper {

    List<OauthCode> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthCode record);

    int update(OauthCode record);
}