package com.igeek.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="lifeCycleBean")
@Scope("prototype")
public class LifeCycleBean {
	public LifeCycleBean() {
		System.out.println("LifeCycleBean 被创建");
	}
	@PostConstruct
	public void init(){
		System.out.println("初始化");
		
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("销毁");
	}
}
