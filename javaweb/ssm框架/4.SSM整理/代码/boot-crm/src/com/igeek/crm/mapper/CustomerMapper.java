package com.igeek.crm.mapper;

import com.igeek.crm.pojo.Customer;
import com.igeek.crm.pojo.CustomerExample;
import com.igeek.crm.pojo.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
	
   List<Customer> queryCustomerByQueryVo(QueryVo queryVo);
   
   int queryCountByQueryVo(QueryVo queryVo);
   
   Customer queryCustomerById(Long id);

   void updateCustomerById(Customer customer);

   void deleteCustomerById(Long id);
   
}