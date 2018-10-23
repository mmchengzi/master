package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.NAdminDao;
import com.masterchengzi.newsserver.entity.NAdmin;
import com.masterchengzi.newsserver.mapper.NAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class NAdminDaoImpl implements NAdminDao {
	@Autowired
	private NAdminMapper nAdminMapper;

	@Override
	public List<NAdmin> getNAdmin(Integer id, String name) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("name", name);
		return nAdminMapper.getNAdmin(map);
	}

	@Override
	public int delete(Integer id) {
		Map map = new HashMap();
		map.put("id", id);
		return nAdminMapper.delete(map);
	}

	@Override
	public int insert(NAdmin record) {
		return nAdminMapper.insert(record);
	}

	@Override
	public int update(NAdmin record) {
		return nAdminMapper.update(record);
	}
}
