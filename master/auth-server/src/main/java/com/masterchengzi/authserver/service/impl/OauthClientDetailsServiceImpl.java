package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.ClientDetailsMapper;
import com.masterchengzi.authserver.mapper.OauthClientDetailsMapper;
import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthClientDetails;
import com.masterchengzi.authserver.service.OauthClientDetailsService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {
	@Autowired
	private OauthClientDetailsMapper mapper;
	@Override
	public JsonResult getList(String client_id, String resource_ids) {
		try {
			Map map = new HashMap();
			map.put("clientId", client_id);
			map.put("resourceIds", resource_ids);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.getList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String client_id, String resource_ids) {
		try {
			Map map = new HashMap();
			map.put("clientId", client_id);
			map.put("resourceIds", resource_ids);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.delete(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(OauthClientDetails record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(OauthClientDetails record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
