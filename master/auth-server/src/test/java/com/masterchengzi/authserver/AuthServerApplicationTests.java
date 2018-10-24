package com.masterchengzi.authserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServerApplicationTests {
//$2a$10$1thVfPqDDFI.dl7D3etcTegSz8PTIIEvqTbMgF4THCdJXkSG2PeDW
	@Test
	public void contextLoads() {
	String 	password = new BCryptPasswordEncoder().encode("123456");
	System.out.println("密码:"+password);
	}

}
