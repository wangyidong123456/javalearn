package com.igeek.xmllifecycle;

public class LifeCycleBean {
	public LifeCycleBean() {
		System.out.println("LifeCycleBean ��������");
	}
	
	public void init(){
		System.out.println("init ���̡��������");
	}
	
	public void destroy(){
		System.out.println("destory ����...");
	}
	
	public void save(){
		System.out.println("save������");
	}
}
