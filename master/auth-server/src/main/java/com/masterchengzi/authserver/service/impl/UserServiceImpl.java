package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.UserMapper;
import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
	public JsonResult insert(MyUser record) {
		try {
			if (exist(record.getUsername())){
				return new JsonResult(ResultCode.SUCCESS_IS_HAVE, ResultCode.SUCCESS_IS_HAVE.msg());
			}
			encryptPassword(record);
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.insert(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	@Override
	public JsonResult update(MyUser record) {
		try {
			if(record.getPassword()!=null){
				encryptPassword(record);
			}
			return new JsonResult(ResultCode.SUCCESS, "成功", mapper.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}
	}

	/**
	 * 判断用户是否存在
	 * @param username 账号
	 * @return 密码
	 */
	private boolean exist(String username){
		Map map = new HashMap();
		map.put("id", null);
		map.put("username", username);
		List<MyUser>  userEntity = mapper.getList(map);
		if(userEntity!=null&&userEntity.size()>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 加密密码
	 */
	private void encryptPassword(MyUser userEntity){
		String password = userEntity.getPassword();
		password = new BCryptPasswordEncoder().encode(password);
		userEntity.setPassword(password);
	}
}
