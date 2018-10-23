package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.NewsTagDeep;

import java.util.List;

public interface  NewsTagDeepDao {
	List<NewsTagDeep> getNewsTagDeep(String newsId);

	int delete(String newsId);

	int insert(NewsTagDeep record);

	int update(NewsTagDeep record);
}