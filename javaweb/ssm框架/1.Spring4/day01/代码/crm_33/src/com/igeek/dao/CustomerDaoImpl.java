package com.igeek.dao;

import com.igeek.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		//连接数据库，保存数据
		System.out.println("执行了CustomerDaoImpl");
	}

}
