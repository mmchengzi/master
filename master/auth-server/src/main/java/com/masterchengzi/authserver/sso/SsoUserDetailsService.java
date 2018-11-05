package com.masterchengzi.authserver.sso;

import com.masterchengzi.authserver.model.MyUser;
import com.masterchengzi.authserver.service.UserService;
import com.masterchengzi.mastercommon.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/12/26.
 *
 * @author zlf
 * @since 1.0
 */
@Component
public class SsoUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService     userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JsonResult userResult = userService.getList(null, username);
        List<MyUser> users = new ArrayList<>();
        if ("200".equals(userResult.getCode()) && users.size() > 0) {
            throw new UsernameNotFoundException("用户:" + username + ",不存在!");
        } else {
            //passwordEncoder.encode(users.get(0).getPassword()) 加密方法
            users = (List<MyUser>) userResult.getData();
            return new User(username, users.get(0).getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));

        }
    }
}
