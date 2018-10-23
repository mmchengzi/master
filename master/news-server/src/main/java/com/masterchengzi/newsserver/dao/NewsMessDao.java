package com.masterchengzi.authserver.dao;

import com.masterchengzi.authserver.entity.NewsMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface NewsMessDao {
	List<NewsMess> getNewsMess(String newsId,String tag);

	int delete(String newsId);

	int insert(NewsMess record);

	int update(NewsMess record);
}