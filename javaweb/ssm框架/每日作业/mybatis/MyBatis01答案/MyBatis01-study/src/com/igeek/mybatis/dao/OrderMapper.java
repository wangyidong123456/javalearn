package com.igeek.mybatis.dao;

import java.util.List;

import com.igeek.mybatis.pojo.Order;

public interface OrderMapper {

	public Order queryOrderById(int id);

	public List<Order> queryOrderByNote(String note);

	public void saveOrder(Order user);

	public void updateOrder(Order user);

	public void deleteOrderById(int id);
}
