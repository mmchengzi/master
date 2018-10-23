package com.masterchengzi.authserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mss-upms",fallback = RoleServiceImpl.class)
public interface RoleService {
	@GetMapping("role/getRoleByUserId/{userId}")
	Result<List<RoleVo>> getRoleByUserId(@PathVariable("userId") Integer userId);
}
