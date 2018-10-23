package com.masterchengzi.newsserver.dao;

import com.masterchengzi.newsserver.entity.GetNewsWithBLOBs;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface GetNewsDao {
	List<GetNewsWithBLOBs> getGetNews(String newsId,String title,String keyword,String tag,Integer isOld,Date beginDate,Date endDate);

	int delete(String newsId);

	int insert(GetNewsWithBLOBs record);
	int update(GetNewsWithBLOBs record);
}