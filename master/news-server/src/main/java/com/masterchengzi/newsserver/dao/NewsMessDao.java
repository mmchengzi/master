package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NewsMess;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface NewsMessDao {
	List<NewsMess> getNewsMess(String newsId,String tag);

	int delete(String newsId);

	int insert(NewsMess record);

	int update(NewsMess record);
}