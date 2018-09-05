package com.igeek;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean4 bean4 =  (Bean4) ac.getBean("bean4");
		System.out.println(bean4);
	}
}
