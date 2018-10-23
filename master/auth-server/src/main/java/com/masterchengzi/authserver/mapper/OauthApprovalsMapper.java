package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthAccessTokenWithBLOBs;
import com.masterchengzi.authserver.model.OauthApprovals;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthApprovalsMapper {

    List<OauthApprovals> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthApprovals record);

    int update(OauthApprovals record);
}