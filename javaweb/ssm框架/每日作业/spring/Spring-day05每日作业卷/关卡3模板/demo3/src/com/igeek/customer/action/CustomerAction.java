package com.igeek.customer.action;

import com.igeek.customer.domain.Customer;
import com.igeek.customer.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private Customer customer = new Customer();
	
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String save(){
		customerService.save(customer);
		return NONE;
	}
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public String list(){
		
		return "list";
	}
}
