package com.igeek.customer.service;

import java.util.List;

import com.igeek.customer.domain.Customer;

public interface CustomerService {
	
	public void save(Customer customer);
	
	public List<Customer> list();

}
