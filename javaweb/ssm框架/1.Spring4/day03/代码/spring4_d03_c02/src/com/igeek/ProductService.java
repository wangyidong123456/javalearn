package com.igeek;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService {
	public void save(){
		System.out.println("商品保存");
	}
	
	public int find(){
		System.out.println("商品查找");
//		int i = 1/0;
		return 99;
	}
}
