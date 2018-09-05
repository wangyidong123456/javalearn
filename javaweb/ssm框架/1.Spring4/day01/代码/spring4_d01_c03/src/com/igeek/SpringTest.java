package com.igeek;

import org.junit.Test;

public class SpringTest {
	@Test
	public void test(){
		//传统的方式
		IUserService userService = new UserServiceImpl();
		userService.login();
	}
}
