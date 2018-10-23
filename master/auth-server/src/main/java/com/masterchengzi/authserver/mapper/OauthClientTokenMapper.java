package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthApprovals;
import com.masterchengzi.authserver.model.OauthClientToken;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthClientTokenMapper {
    List<OauthClientToken> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthClientToken record);

    int update(OauthClientToken record);

}