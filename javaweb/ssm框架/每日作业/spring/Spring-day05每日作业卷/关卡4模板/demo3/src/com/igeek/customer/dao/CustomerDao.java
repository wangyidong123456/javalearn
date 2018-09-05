package com.igeek.customer.dao;

import java.util.List;

import com.igeek.customer.domain.Customer;

public interface CustomerDao {
	
	public void save(Customer customer);

	public List<Customer> list();

}
