package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.ClientDetails;

public interface ClientDetailsMapper {
    int deleteByPrimaryKey(String appid);

    int insert(ClientDetails record);

    int insertSelective(ClientDetails record);

    ClientDetails selectByPrimaryKey(String appid);

    int updateByPrimaryKeySelective(ClientDetails record);

    int updateByPrimaryKey(ClientDetails record);
}