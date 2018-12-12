package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;

import java.util.Date;
import java.util.List;

public interface GetNewsDao {
	List<GetNewsWithBLOBs> getGetNews(String newsId, String title, String keyword, String tag, Integer isOld, Date beginDate, Date endDate);

	int delete(String newsId,  String keyword, String tag, Integer isOld, Date beginDate, Date endDate);

	int insert(GetNewsWithBLOBs record);

	int update(GetNewsWithBLOBs record);
}