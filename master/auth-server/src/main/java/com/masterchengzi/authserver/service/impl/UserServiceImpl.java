package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.mapper.UserMapper;
import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.authserver.util.JwtTokenUtil;
import com.masterchengzi.mastercommon.common.JsonResult;
import com.masterchengzi.mastercommon.common.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper            mapper;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService    userDetailsService;
	@Autowired
	private JwtTokenUtil          jwtTokenUtil;
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

	/**
	 * 用户注册
	 * @param record
	 * @return
	 */
	@Override
	public JsonResult register(MyUser record) {
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
	 * 用户登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 操作结果
	 */
	@Override
	public JsonResult login(String username, String password) {
		try {UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = authenticationManager.authenticate(upToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			return new JsonResult(ResultCode.SUCCESS,"成功",jwtTokenUtil.generateToken(userDetails)) ;
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(ResultCode.FAIL, e.getMessage());
		}

	}
	/**
		 * 刷新密钥
	 *
	 * @param oldToken 原密钥
	 * @return 新密钥
	 */
	@Override
	public JsonResult refreshToken(String oldToken) {
		try {
			String token = oldToken.substring("Bearer ".length());
			if (!jwtTokenUtil.isTokenExpired(token)) {
				return new JsonResult(ResultCode.SUCCESS,jwtTokenUtil.refreshToken(token)) ;
			}else{
				return new JsonResult(ResultCode.FAIL,"令牌过期！");
			}
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
