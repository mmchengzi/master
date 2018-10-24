package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.ClientDetailsMapper;
import com.masterchengzi.authserver.mapper.PrivilegeMapper;
import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.authserver.service.PrivilegeService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	@Autowired
	private PrivilegeMapper mapper;
	@Override
	public JsonResult getList(String role_id, String menu_id) {
		try {
			Map map = new HashMap();
			map.put("roleId", role_id);
			map.put("menuId", menu_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.getList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String role_id, String menu_id) {
		try {
			Map map = new HashMap();
			map.put("roleId", role_id);
			map.put("menuId", menu_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.delete(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(PrivilegeKey record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(PrivilegeKey record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
