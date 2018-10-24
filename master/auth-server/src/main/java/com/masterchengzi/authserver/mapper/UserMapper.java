package com.masterchengzi.authserver.mapper;

import com.masterchengzi.authserver.model.MyUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface UserMapper {
    List<MyUser> getList(Map<String, Object> map);

    int delete(Map<String, Object> map);

    int insert(MyUser record);

    int update(MyUser record);
}