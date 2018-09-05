package com.igeek.ioc;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean id="customerService" class="com.igeek.ioc.CustomerService">
//@Component(value="customerService")
@Service(value="customerService")
public class CustomerService {
	@Value("Rose")
	private String name="jack";
//	@Value(value="#{customerDao}")
//	@Inject
//	@Named("customerDao")
	@Autowired
	@Qualifier("customerDao") 
	@Resource
	private CustomerDao customerDao;
	
	
//	@Value(value="#{customerDao}")
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	public void save(){
		
		System.out.println("CustomerService--save");
		System.out.println(name);
		customerDao.save();
	}
}
