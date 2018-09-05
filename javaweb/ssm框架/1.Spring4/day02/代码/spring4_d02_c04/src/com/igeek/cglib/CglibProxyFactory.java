package com.igeek.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//cglib��̬������:��������cglib�������
public class CglibProxyFactory implements MethodInterceptor{
	//����һ�������������
	private Object target;
	//ע��������
	public CglibProxyFactory(Object target) {
		this.target = target;
	}
	
	//��ȡ�������
	public Object getProxyObject(){
		//1.�������������(����˼��)
		Enhancer enhancer = new Enhancer();
//�������
		enhancer.setClassLoader(target.getClass().getClassLoader());
		//2.����ǿ����������������
		//����Ҫ���ɴ�������Ŀ��������ɵ�Ŀ��������͵�������
		enhancer.setSuperclass(target.getClass());
		//���ûص�����
		enhancer.setCallback(this);
//		Callback
		//3.������ȡ����
		return enhancer.create();
	}

	
	//�ص��������������ķ�����
	//����1���������
	//����2��Ŀ�����ķ�������
	//����3��Ŀ�����ķ����Ĳ�����ֵ
	//����4���������ķ�������
	public Object intercept(Object proxy, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		//����Ǳ���ķ�����ִ�м�¼��־����
		if(method.getName().equals("save")){
			writeLog();
		}
		//Ŀ�����ԭ���ķ���ִ��
		Object object = method.invoke(target, args);//����Ŀ������ĳ�����������ҷ���Ŀ�����
		return object;
	}
	
	//д��־����ǿ����
	//Advice֪ͨ����ǿ
	//��¼��־
	private static void writeLog(){
		System.out.println("��ǿ���룺д��־�ˡ�����");
	}
	
}

