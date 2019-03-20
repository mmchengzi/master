package com.masterchengzi.travelserver.dao.impl;

import com.masterchengzi.travelserver.dao.NewDao;
import com.masterchengzi.travelserver.entity.Item;
import com.masterchengzi.travelserver.entity.New;
import com.masterchengzi.travelserver.mapper.NewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NewDaoImpl implements NewDao {
    @Autowired
    private NewMapper newMapper;
    @Override
    public List<New> getList(Integer newId, Integer parentId, String openId, Date beginTime, Date endTime) {
        Map map = new HashMap();
        map.put("newId", newId);
        map.put("parentId", parentId);
        map.put("openId", openId);
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return newMapper.getList(map);
    }

    @Override
    public int delete(Integer newId, Integer parentId, String openId) {
        Map map = new HashMap();
        map.put("newId", newId);
        map.put("parentId", parentId);
        map.put("openId", openId);
        return newMapper.delete(map);
    }

    @Override
    public int insert(New record) {
        return newMapper.insert(record);
    }
    @Override
    public int update(New record) {
            return newMapper.update(record);
    }
}
