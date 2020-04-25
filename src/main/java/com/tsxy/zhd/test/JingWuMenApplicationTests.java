package com.tsxy.zhd.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest()
class JingWuMenApplicationTests {

	@Test
	void contextLoads() {
		String password="admin";
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(md5Password);
	}

}
