package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthApprovals;

public interface OauthApprovalsMapper {
    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);
}