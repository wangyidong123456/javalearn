package com.igeek.xmllifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//后处理bean，：用来对bean进行功能增强，可以实现，对所有，或某个bean的初始化进行增强
public class MyBeanPostProcessor implements BeanPostProcessor{

	//初始化时（之前）调用的
	//参数1：bean对象，参数2，bean的名字，id、name
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println(beanName+"在初始化前开始增强了");
		//如何只增强一个bean
		if(beanName.equals("lifeCycleBean")){
			System.out.println(beanName+"在初始化前开始增强了");
		}
		return bean;//放行
	}

	//初始化时（之后）调用
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println(beanName+"在初始化后开始增强了");
		if(beanName.equals("lifeCycleBean")){
			System.out.println(beanName+"在初始化后开始增强了");
		}
		return bean;
	}

}
