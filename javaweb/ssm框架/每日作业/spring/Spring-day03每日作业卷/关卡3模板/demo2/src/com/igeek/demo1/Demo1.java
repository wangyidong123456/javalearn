package com.igeek.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 娴嬭瘯鏂规硶
 * @author Administrator
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo1 {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Test
	public void run1(){
		userService.save();
		userService.delete();
	}

}
