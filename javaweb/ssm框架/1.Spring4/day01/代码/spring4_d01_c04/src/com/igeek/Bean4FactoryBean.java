package com.igeek;

import org.springframework.beans.factory.FactoryBean;

public class Bean4FactoryBean implements FactoryBean<Bean4>{
	//������ȡbean��ʵ��������
	public Bean4 getObject() throws Exception {
		//дһЩ��ʼ�����ݿ����ӵȵ���������
		return new Bean4();
	}
	public Class<?> getObjectType() {
		return null;
	}
	public boolean isSingleton() {
		return false;
	}
}
