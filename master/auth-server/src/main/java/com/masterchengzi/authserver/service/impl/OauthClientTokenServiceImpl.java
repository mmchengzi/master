package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.ClientDetailsMapper;
import com.masterchengzi.authserver.mapper.OauthClientTokenMapper;
import com.masterchengzi.authserver.model.ClientDetails;
import com.masterchengzi.authserver.model.OauthClientToken;
import com.masterchengzi.authserver.service.OauthClientTokenService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OauthClientTokenServiceImpl implements OauthClientTokenService {
	@Autowired
	private OauthClientTokenMapper mapper;
	@Override
	public JsonResult getList(String token_id, String authentication_id) {
		try {
			Map map = new HashMap();
			map.put("tokenId", token_id);
			map.put("authenticationId", authentication_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.getList(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult delete(String token_id, String authentication_id) {
		try {
			Map map = new HashMap();
			map.put("tokenId", token_id);
			map.put("authenticationId", authentication_id);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.delete(map));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult insert(OauthClientToken record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(OauthClientToken record) {
		try {
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}
}
