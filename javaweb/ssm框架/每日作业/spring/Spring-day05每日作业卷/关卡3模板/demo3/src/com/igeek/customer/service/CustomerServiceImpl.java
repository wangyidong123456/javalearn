package com.igeek.customer.service;

import java.util.List;

import com.igeek.customer.dao.CustomerDao;
import com.igeek.customer.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	public List<Customer> list() {
		return customerDao.list();
	}

}
