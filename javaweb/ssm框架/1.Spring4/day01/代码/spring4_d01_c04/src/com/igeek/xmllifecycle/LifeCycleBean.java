package com.igeek.xmllifecycle;

public class LifeCycleBean {
	public LifeCycleBean() {
		System.out.println("LifeCycleBean 被创建了");
	}
	
	public void init(){
		System.out.println("init 戒烟。。。戒酒");
	}
	
	public void destroy(){
		System.out.println("destory 销毁...");
	}
	
	public void save(){
		System.out.println("save。。。");
	}
}
