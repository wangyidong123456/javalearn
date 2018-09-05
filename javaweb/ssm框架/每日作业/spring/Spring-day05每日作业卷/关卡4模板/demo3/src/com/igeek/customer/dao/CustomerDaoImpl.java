package com.igeek.customer.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.igeek.customer.domain.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private HibernateTemplate hibernateTemplate;

	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	public List<Customer> list() {
		return null;
	}

}
