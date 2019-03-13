package com.masterchengzi.travelserver.dao.impl;

import com.masterchengzi.travelserver.dao.UserOperateDao;
import com.masterchengzi.travelserver.entity.UserOperate;
import com.masterchengzi.travelserver.mapper.UserOperateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class UserOperateDaoImpl implements UserOperateDao {
    @Autowired
    private UserOperateMapper mapper;
    @Override
    public List<UserOperate> getList(Integer userId, Integer itemId,Integer partnerId,String version, Date beginTime, Date endTime) {
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("itemId", itemId);
        map.put("partnerId", partnerId);
        map.put("version", version);
        map.put("beginTime", beginTime);
        map.put("endTime", endTime);
        return mapper.getList(map);
    }

    @Override
    public int delete(Integer userId, Integer itemId,String version) {
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("itemId", itemId);
        map.put("version", version);
        return mapper.delete(map);
    }

    @Override
    public int insert(UserOperate record) {
        return mapper.insert(record);
    }

    @Override
    public int update(UserOperate record) {
        return mapper.update(record);
    }
}
