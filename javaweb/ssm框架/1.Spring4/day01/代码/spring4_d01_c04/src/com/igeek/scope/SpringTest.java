package com.igeek.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.Bean4;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取2次单例对象
		SingletonBean s1 = (SingletonBean) ac.getBean("singletonBean");
		SingletonBean s2 = (SingletonBean) ac.getBean("singletonBean");
		PrototypeBean pb1 = (PrototypeBean) ac.getBean("prototypeBean");
		PrototypeBean pb2 = (PrototypeBean) ac.getBean("prototypeBean");
	}
}
