package com.igeek.ioc.mixed;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-mixed.xml");
		ProductService ps = (ProductService) ac.getBean("productService");
		ps.save();
	}
	
	
}
