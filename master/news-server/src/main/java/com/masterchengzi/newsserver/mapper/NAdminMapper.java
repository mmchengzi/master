package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.entity.NAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NAdminMapper {

    List<NAdmin> getNAdmin(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(NAdmin record);

    int update(NAdmin record);
}