package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

	List<User> getUser(String userId, String name, String phone, Date benginDate,Date endDate);
	int delete(String userId, String name, String phone);

	int insert(User record);

	int update(User record);
}