package com.masterchengzi.authserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mss-upms",fallback = UserServiceImpl.class)
public interface UserService {
	@GetMapping("user/findByUsername/{username}")
	Result<UserVo> findByUsername(@PathVariable("username") String username);
}
