package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NAdmin;

import java.util.List;

public interface NAdminDao {

    List<NAdmin> getNAdmin(Integer id, String name);

    int delete(Integer id);

    int insert(NAdmin record);

    int update(NAdmin record);
}