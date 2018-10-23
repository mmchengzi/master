package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface NAdminDao {

    List<NAdmin> getNAdmin(Integer id,String name);

    int delete(Integer id);

    int insert(NAdmin record);

    int update(NAdmin record);
}