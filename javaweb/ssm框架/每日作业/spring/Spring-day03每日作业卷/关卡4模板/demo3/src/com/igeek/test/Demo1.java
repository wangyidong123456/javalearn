package com.igeek.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.domain.User;
import com.igeek.service.UserService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo1 {
	
	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 测试保存的方法
	 */
	@Test
	public void run1(){
		User user = new User();
		user.setName("王五");
		user.setAge(18);
		// 保存用户
		userService.save(user);
	}

}
