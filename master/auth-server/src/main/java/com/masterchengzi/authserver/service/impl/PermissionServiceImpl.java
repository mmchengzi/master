package com.masterchengzi.authserver.service.impl;

import com.masterchengzi.authserver.service.PermissionService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;

@Log4j2
@Service
public class PermissionServiceImpl implements PermissionService {
	@Override
	public Result<List<MenuVo>> getRolePermission(Integer roleId) {
		log.info("调用{}失败","getRolePermission");
		return Result.failure(100,"调用getRolePermission失败");
	}
}
