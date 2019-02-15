package com.masterchengzi.travelserver.dao.impl;

import com.masterchengzi.travelserver.dao.ItemDao;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getList(Integer itemId,String itemName, String type, Date beginTime, Date endTime) {
        Map map = new HashMap();
        map.put("itemId", itemId);
        map.put("itemName", itemName);
        map.put("type", type);
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return itemMapper.getList(map);
    }

    @Override
    public int delete(Integer itemId) {
        Map map = new HashMap();
        map.put("itemId", itemId);
        return itemMapper.delete(map);
    }

    @Override
    public int insert(Item record) {
        return itemMapper.insert(record);
    }

    @Override
    public int update(Item record) {
        return itemMapper.update(record);
    }
}
