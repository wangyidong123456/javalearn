package com.igeek.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.igeek.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SpringTest {
	//注入测试的service
	@Autowired
	private IAccountService accountService;
	
	//需求：账号转账，Tom账号取出1000元，存放到Jack账号上
	@Test
	public void testTransfer(){
		accountService.transfer("冠希", "美美", 1000d);
		System.out.println("转账成功！");
	}

}

