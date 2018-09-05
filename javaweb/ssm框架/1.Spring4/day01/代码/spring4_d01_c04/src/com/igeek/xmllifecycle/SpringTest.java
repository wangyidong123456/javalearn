package com.igeek.xmllifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.scope.PrototypeBean;
import com.igeek.scope.SingletonBean;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		LifeCycleBean bean = (LifeCycleBean) ac.getBean("lifeCycleBean");
		bean.save();
		((ClassPathXmlApplicationContext)ac).close();
		
	}
}
