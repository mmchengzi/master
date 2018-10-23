package com.masterchengzi.newsserver.service.impl;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import com.masterchengzi.newsserver.dao.NAdminDao;
import com.masterchengzi.newsserver.entity.NAdmin;
import com.masterchengzi.newsserver.service.NAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NAdminServiceImpl implements NAdminService {
	@Autowired
	private NAdminDao nAdminDao;
	@Override
	public JsonResult getNAdmin(Integer id, String name) {
		try {
			List<NAdmin> resultList= nAdminDao.getNAdmin(id,name);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult delete(Integer id) {
		try {
			Integer resultList= nAdminDao.delete(id);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult insert(NAdmin record) {
		try {
			Integer resultList= nAdminDao.insert(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}

	@Override
	public JsonResult update(NAdmin record) {
		try {
			Integer resultList= nAdminDao.update(record);
			return new JsonResult(ResultCode.SUCCESS,"成功",resultList);
		}catch (Exception e){
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL,e.getMessage());
		}
	}
}
