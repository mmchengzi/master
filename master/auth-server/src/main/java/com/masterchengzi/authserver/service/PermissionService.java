package com.masterchengzi.authserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mss-upms",fallback = PermissionServiceImpl.class)
public interface PermissionService {
	@GetMapping("permission/getRolePermission/{roleId}")
	Result<List<MenuVo>> getRolePermission(@PathVariable("roleId") Integer roleId);
}