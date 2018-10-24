package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.ClientDetailsMapper;
import com.masterchengzi.authserver.mapper.UserMapper;
import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.User;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper mapper;
	@Override
	public JsonResult getList(String id, String username) {
		try {
			Map map = new HashMap();
			map.put("id", id);
			map.put("username", username);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.getList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String id, String username) {
		try {
			Map map = new HashMap();
			map.put("id", id);
			map.put("username", username);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.delete(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(User record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(User record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
