package com.igeek;

import org.junit.Test;

public class SpringTest {
	@Test
	public void test(){
		//��ͳ�ķ�ʽ
		IUserService userService = new UserServiceImpl();
		userService.login();
	}
}
