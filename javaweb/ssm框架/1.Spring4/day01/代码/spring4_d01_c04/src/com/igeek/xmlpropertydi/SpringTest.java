package com.igeek.xmlpropertydi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.scope.PrototypeBean;
import com.igeek.scope.SingletonBean;

public class SpringTest {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		Car car = (Car) ac.getBean("car");
//		System.out.println(car);
//		Person person = (Person) ac.getBean("person");
//		Person person2 = (Person) ac.getBean("person2");
//		System.out.println(person2);
//		Person person3 = (Person) ac.getBean("person3");
//		System.out.println(person3);
		CollectionBean collectionBean = (CollectionBean) ac.getBean("collectionBean");
		System.out.println(collectionBean);
		
	}
}
