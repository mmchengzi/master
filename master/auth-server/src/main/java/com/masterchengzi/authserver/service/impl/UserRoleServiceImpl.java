package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.ClientDetailsMapper;
import com.masterchengzi.authserver.mapper.UserRoleMapper;
import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.UserRole;
import com.masterchengzi.authserver.service.UserRoleService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleMapper mapper;
	@Override
	public JsonResult getList(String id,String user_id) {
		try {
			Map map = new HashMap();
			map.put("id", id);
			map.put("userId", user_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.getList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String id,String user_id) {
		try {
			Map map = new HashMap();
			map.put("id", id);
			map.put("userId", user_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.delete(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(UserRole record) {
		try {

			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(UserRole record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
