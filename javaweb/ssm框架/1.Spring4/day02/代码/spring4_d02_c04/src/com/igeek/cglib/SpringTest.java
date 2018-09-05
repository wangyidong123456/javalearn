package com.igeek.cglib;

import org.junit.Test;

public class SpringTest {
	//cglib��̬�������Ի����ࣨ����ʵ�ֽӿڣ����ɴ������
	@Test
	public void testCglibProxy(){
		//targetĿ�꣺
		ProductService target = new ProductService();
		//weave֯�룬����proxy�������
		//����������ע��Ŀ��
		CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(target);
		//��ȡproxy:˼�������������
		//���������ʵ��Ŀ��������͵�������
		ProductService proxy=(ProductService) cglibProxyFactory.getProxyObject();
		//���ô������ķ���
		proxy.save();
		System.out.println("��������������������������������������������������������������������������������");
		proxy.find();
		
	}

}
