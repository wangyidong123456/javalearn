package com.igeek;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {
	public void save(){
		System.out.println("��Ʒ����");
	}
	
	public int find(){
		System.out.println("��Ʒ����");
//		int i = 1/0;
		return 99;
	}
}
