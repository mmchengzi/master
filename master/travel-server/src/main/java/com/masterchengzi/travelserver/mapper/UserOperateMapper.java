package com.masterchengzi.travelserver.mapper;

import com.masterchengzi.travelserver.entity.UserOperate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserOperateMapper {
    List<UserOperate> getList(Map<String, Object> map);
    int delete(Map<String, Object> map);
    int insert(UserOperate record);
    int update(UserOperate record);
}