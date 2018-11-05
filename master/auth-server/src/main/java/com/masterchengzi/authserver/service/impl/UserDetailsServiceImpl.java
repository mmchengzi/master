package com.masterchengzi.authserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.authserver.model.PrivilegeKey;
import com.masterchengzi.authserver.model.Role;
import com.masterchengzi.authserver.model.UserRole;
import com.masterchengzi.authserver.service.PrivilegeService;
import com.masterchengzi.authserver.service.RoleService;
import com.masterchengzi.authserver.service.UserRoleService;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.mastercommon.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*@Service*/
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService      userService;
	@Autowired
	private RoleService      roleService;
	@Autowired
	private UserRoleService  userRoleService;
	@Autowired
	private PrivilegeService privilegeService;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JsonResult userResult = userService.getList(null, username);
		List<MyUser> users = new ArrayList<>();
		if ("200".equals(userResult.getCode())&&users.size() >0) {
				throw new UsernameNotFoundException("用户:" + username + ",不存在!");
		}
		users = (List<MyUser>) userResult.getData();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		boolean enabled = true; // 可用性 :true:可用 false:不可用
		boolean accountNonExpired = true; // 过期性 :true:没过期 false:过期
		boolean credentialsNonExpired = true; // 有效性 :true:凭证有效 false:凭证无效
		boolean accountNonLocked = true; // 锁定性 :true:未锁定 false:已锁定
		JsonResult userRoleServiceList = userRoleService.getList(null, users.get(0).getId().toString());
		List<Role> roles = new ArrayList<>();
		if ("200".equals(userRoleServiceList.getCode())) {
			List<UserRole> userRoles = (List<UserRole>) userRoleServiceList.getData();
			roles = (List<Role>) roleService.getList(userRoles.get(0).getId().toString(), null).getData();
			for (Role role : roles) {
				//角色必须是ROLE_开头，可以在数据库中设置
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
				grantedAuthorities.add(grantedAuthority);
				//获取权限
				JsonResult perResult = privilegeService.getList(role.getId().toString(), null);
				//	List<PrivilegeKey> perResult
				if ("200".equals(perResult.getCode())) {
					List<PrivilegeKey> permissionList = (List<PrivilegeKey>) perResult.getData();
					for (PrivilegeKey menu : permissionList) {
						GrantedAuthority authority = new SimpleGrantedAuthority(menu.getMenuId());
						grantedAuthorities.add(authority);
					}
				}
			}
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "{bcrypt}"+bCryptPasswordEncoder.encode(users.get(0).getPassword());
		User user = new User(users.get(0).getUsername(), password,
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
		return user;
	}
}