package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.UserOperate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserOperateDao {
	List<UserOperate> getUserOperate(String userId,String newsId);

	int delete(String userId,String newsId);

	int insert(UserOperate record);

	int update(UserOperate record);
}