package com.masterchengzi.travelserver.mapper;

import com.masterchengzi.travelserver.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface ItemMapper {
    List<Item> getList(Map<String, Object> map);
    int delete(Map<String, Object> map);
    int insert(Item record);
    int update(Item record);
}