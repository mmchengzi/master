package com.masterchengzi.authserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.authserver.dao.NewsMessDao;
import com.masterchengzi.authserver.entity.NewsMess;
import com.masterchengzi.authserver.service.NewsMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsMessServiceImpl implements NewsMessService {
	@Autowired
	private NewsMessDao newsMessDao;
	@Override
	public JsonResult getNewsMess(String newsId, String tag) {
		try {
			List<NewsMess> resultList= newsMessDao.getNewsMess(newsId, tag);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String newsId) {
		try {
			Integer resultList= newsMessDao.delete(newsId);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NewsMess record) {
		try {
			Integer resultList= newsMessDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(NewsMess record) {
		try {
			Integer resultList= newsMessDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
