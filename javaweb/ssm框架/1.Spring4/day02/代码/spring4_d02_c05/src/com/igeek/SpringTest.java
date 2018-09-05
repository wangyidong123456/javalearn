package com.igeek;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//springjunit���ɲ���
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpringTest {
	//ע��Ҫ����bean
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ProductService productService;
	
	//����
	@Test
	public void test(){
		//���ڽӿ�
		customerService.save();
		customerService.find();
		//�������
		productService.save();
		productService.find();
	}

}

