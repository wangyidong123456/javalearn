package com.igeek.demo1;

import org.junit.Test;

import com.igeek.service.UserService;
import com.igeek.service.impl.UserServiceImpl;

/**
 * 测试方法
 * @author Administrator
 */
public class Demo1 {
	
	@Test
	public void run1(){
		UserService us = new UserServiceImpl();
		us.save();
		us.delete();
	}

}
