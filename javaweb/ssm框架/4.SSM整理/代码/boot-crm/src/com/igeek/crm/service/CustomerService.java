package com.igeek.crm.service;

import com.igeek.crm.pojo.Customer;
import com.igeek.crm.pojo.QueryVo;
import com.igeek.crm.utils.Page;

public interface CustomerService {
	/**
	 * 根据条件分页查询客户
	 * 
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);
	
	/**
	 * 根据id查询数据
	 * 
	 * @param id
	 * @return
	 */
	Customer queryCustomerById(Long id);

	void updateCustomerById(Customer customer);

	void deleteCustomerById(Long id);

	
	

}
