package com.masterchengzi.authserver;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class AuthServerApplicationTests {

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
		System.out.println(password);
	}

}
