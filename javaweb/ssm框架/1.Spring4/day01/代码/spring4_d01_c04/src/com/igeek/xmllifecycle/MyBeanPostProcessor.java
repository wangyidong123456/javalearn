package com.igeek.xmllifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//����bean����������bean���й�����ǿ������ʵ�֣������У���ĳ��bean�ĳ�ʼ��������ǿ
public class MyBeanPostProcessor implements BeanPostProcessor{

	//��ʼ��ʱ��֮ǰ�����õ�
	//����1��bean���󣬲���2��bean�����֣�id��name
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println(beanName+"�ڳ�ʼ��ǰ��ʼ��ǿ��");
		//���ֻ��ǿһ��bean
		if(beanName.equals("lifeCycleBean")){
			System.out.println(beanName+"�ڳ�ʼ��ǰ��ʼ��ǿ��");
		}
		return bean;//����
	}

	//��ʼ��ʱ��֮�󣩵���
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
//		System.out.println(beanName+"�ڳ�ʼ����ʼ��ǿ��");
		if(beanName.equals("lifeCycleBean")){
			System.out.println(beanName+"�ڳ�ʼ����ʼ��ǿ��");
		}
		return bean;
	}

}
