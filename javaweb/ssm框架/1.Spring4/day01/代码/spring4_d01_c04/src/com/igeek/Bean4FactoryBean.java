package com.igeek;

import org.springframework.beans.factory.FactoryBean;

public class Bean4FactoryBean implements FactoryBean<Bean4>{
	//用来获取bean的实例，对象
	public Bean4 getObject() throws Exception {
		//写一些初始化数据库连接等等其他代码
		return new Bean4();
	}
	public Class<?> getObjectType() {
		return null;
	}
	public boolean isSingleton() {
		return false;
	}
}
