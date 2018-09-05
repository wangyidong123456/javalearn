package com.igeek.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.service.AccountService;

/**
 * 测试方法
 * @author Administrator
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo1 {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void run1(){
		accountService.pay("关卡3", 1000d,"王五", 1500d);
	}

}
