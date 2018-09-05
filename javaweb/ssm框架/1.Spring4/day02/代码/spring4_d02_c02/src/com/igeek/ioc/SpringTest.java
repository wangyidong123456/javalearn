package com.igeek.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService cs = (CustomerService) ac.getBean("customerService");
		cs.save();
	}
	
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		LifeCycleBean lcb = (LifeCycleBean) ac.getBean("lifeCycleBean");
		LifeCycleBean lcb1 = (LifeCycleBean) ac.getBean("lifeCycleBean");
		((ClassPathXmlApplicationContext)ac).close();
	}
}
