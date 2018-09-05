package com.igeek.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.crm.mapper.CustomerMapper;
import com.igeek.crm.pojo.Customer;
import com.igeek.crm.pojo.QueryVo;
import com.igeek.crm.utils.Page;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		// 设置查询条件,从哪一条数据开始查
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

		
		List<Customer> customers =customerMapper.queryCustomerByQueryVo(queryVo);
		
		int count = customerMapper.queryCountByQueryVo(queryVo);
		
		Page<Customer> page = new Page<>(count, queryVo.getPage(), queryVo.getRows(), customers);

		return page;
	}

	@Override
	public Customer queryCustomerById(Long id) {
		return customerMapper.queryCustomerById(id);
	}

	@Override
	public void updateCustomerById(Customer customer) {
		this.customerMapper.updateCustomerById(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		this.customerMapper.deleteCustomerById(id);
	}

}
