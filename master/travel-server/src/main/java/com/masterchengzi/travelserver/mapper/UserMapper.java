package com.masterchengzi.travelserver.mapper;

import com.masterchengzi.travelserver.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {
    List<User> getList(Map<String, Object> map);
    int delete(Map<String, Object> map);
    int insert(User record);
    int update(User record);
}