package com.igeek;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void save() {
		System.out.println("�ͻ�����");
	}

	@Override
	public int find() {
		System.out.println("�ͻ�����");
		return 0;
	}
	
	//�����ڽӿ���û��
	public void update(){
		System.out.println("�ͻ�����");
	}

	

}
