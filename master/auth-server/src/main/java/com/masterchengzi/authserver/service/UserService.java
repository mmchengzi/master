package com.masterchengzi.authserver.service;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.mastercommon.common.JsonResult;

public interface UserService {
	JsonResult getList(String id, String username);

	JsonResult delete(String id, String username);

	JsonResult update(MyUser record);
	/**
	 * 用户登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return 操作结果
	 */
	JsonResult login(String username, String password);

	/**
	 * 用户注册
	 *
	 * @param user 用户信息
	 * @return 操作结果
	 */
	JsonResult register(MyUser user);

	/**
	 * 刷新密钥
	 *
	 * @param oldToken 原密钥
	 * @return 新密钥
	 */
	JsonResult refreshToken(String oldToken);
}