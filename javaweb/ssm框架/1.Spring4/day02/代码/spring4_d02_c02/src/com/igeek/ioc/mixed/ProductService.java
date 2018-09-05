package com.igeek.ioc.mixed;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}



	public void save(){
		System.out.println("ProductService--save");
		productDao.save();
	}
}
