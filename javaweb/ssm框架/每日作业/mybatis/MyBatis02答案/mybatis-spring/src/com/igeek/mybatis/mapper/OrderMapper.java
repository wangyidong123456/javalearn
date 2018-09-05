package com.igeek.mybatis.mapper;

import java.util.List;

import com.igeek.mybatis.pojo.Order;
import com.igeek.mybatis.pojo.OrderUser;

public interface OrderMapper {

	// 实现查询订单表的数据条数
	public int queryOrderCount();

	// 实现查询所有订单功能，并使用resultMap解决用户id没有获取的问题
	public List<Order> queryOrderAll();

	// 使用自定义pojo的方式，实现订单-用户的一对一查询
	public List<OrderUser> queryOrderUser();

	// 使用resultMap配置，实现订单-用户的一对一查询
	public List<Order> queryOrder();

}
