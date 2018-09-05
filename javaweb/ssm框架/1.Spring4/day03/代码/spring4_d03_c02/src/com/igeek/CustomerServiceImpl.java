package com.igeek;

import org.eclipse.jdt.internal.compiler.env.ICompilationUnit;
import org.springframework.stereotype.Service;


@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

	@Override
	public void save() {
		System.out.println("客户保存");
	}

	@Override
	public int find() {
		System.out.println("客户查找");
		return 0;
	}
	
	//方法在接口中没有
	public void update(){
		System.out.println("客户更新");
	}

	

}
