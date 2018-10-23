package com.masterchengzi.authserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.authserver.dao.NewsHotDao;
import com.masterchengzi.authserver.entity.NewsHot;
import com.masterchengzi.authserver.service.NewsHotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsHotServiceImpl implements NewsHotService {
	@Autowired
	private NewsHotDao newsHotDao;
	@Override
	public JsonResult getNewsHot(String newsId, Date BeginDate, Date EndDate, String title, String tag) {
		try {
			List<NewsHot> resultList= newsHotDao.getNewsHot(newsId, BeginDate, EndDate, title, tag);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
