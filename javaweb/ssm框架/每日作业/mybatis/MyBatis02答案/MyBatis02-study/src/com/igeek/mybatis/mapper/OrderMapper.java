package com.igeek.mybatis.mapper;

import java.util.List;

import com.igeek.mybatis.pojo.Order;

public interface OrderMapper {

	/**
	 * 查询订单的所有数据
	 * 
	 * @return
	 */
	public List<Order> queryOrderAll();


	/**
	 * 查询订单一对一关联用户，使用ResultMap
	 * 
	 * @return
	 */
	public List<Order> queryOrderUser();

}
