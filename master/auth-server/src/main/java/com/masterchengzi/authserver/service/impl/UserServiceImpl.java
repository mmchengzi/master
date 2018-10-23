package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.service.UserService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
	@Override
	public Result<UserVo> findByUsername(String username) {
		log.info("调用{}失败","findByUsername");
		return Result.failure(100,"调用findByUsername接口失败");
	}
}
