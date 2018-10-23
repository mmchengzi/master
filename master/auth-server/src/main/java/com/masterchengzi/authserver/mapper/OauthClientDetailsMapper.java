package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.OauthApprovals;
import com.masterchengzi.authserver.model.OauthClientDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface OauthClientDetailsMapper {
    List<OauthClientDetails> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(OauthClientDetails record);

    int update(OauthClientDetails record);

}