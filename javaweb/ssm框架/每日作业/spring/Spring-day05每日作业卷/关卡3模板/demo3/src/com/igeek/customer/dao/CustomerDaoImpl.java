package com.igeek.customer.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.igeek.customer.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	public List<Customer> list() {
		return null;
	}

}
