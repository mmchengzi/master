package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.service.RoleService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RoleServiceImpl implements RoleService {
	@Override
	public Result<List<RoleVo>> getRoleByUserId(Integer userId) {
		log.info("调用{}失败","getRoleByUserId");
		return Result.failure(100,"调用getRoleByUserId失败");
	}
}
