package com.igeek.service;

import com.igeek.dao.CustomerDao;
import com.igeek.domain.Customer;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao customerDao;
	
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	public void save(Customer customer) {
		System.out.println("÷¥––¡ÀCustomerServiceImpl");
		customerDao.save(customer);
	}

}
