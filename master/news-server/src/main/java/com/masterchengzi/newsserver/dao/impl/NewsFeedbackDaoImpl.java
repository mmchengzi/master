package com.masterchengzi.newsserver.dao.impl;

import com.masterchengzi.newsserver.dao.NewsFeedbackDao;
import com.masterchengzi.newsserver.entity.NewsFeedback;
import com.masterchengzi.newsserver.mapper.NewsFeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class NewsFeedbackDaoImpl implements NewsFeedbackDao {
	@Autowired
	private NewsFeedbackMapper newsFeedbackMapper;

	@Override
	public List<NewsFeedback> getNewsFeedback(String userid, Date beginDate, Date endDate) {
		Map map = new HashMap();
		map.put("userid", userid);
		map.put("beginDate", beginDate);
		map.put("endDate", endDate);
		return newsFeedbackMapper.getNewsFeedback(map);
	}

	@Override
	public int delete(String userid) {
		Map map = new HashMap();
		map.put("userid", userid);
		return newsFeedbackMapper.delete(map);
	}

	@Override
	public int insert(NewsFeedback record) {
		return newsFeedbackMapper.insert(record);
	}

	@Override
	public int update(NewsFeedback record) {
		return newsFeedbackMapper.update(record);
	}
}
