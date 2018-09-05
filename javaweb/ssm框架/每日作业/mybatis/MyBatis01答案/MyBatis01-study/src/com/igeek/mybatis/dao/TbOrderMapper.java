package com.igeek.mybatis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.igeek.mybatis.pojo.TbOrder;

public interface TbOrderMapper {

	// 实现创建订单
	void saveTbOrder(TbOrder tbOrder);

	// 实现根据订单id查询订单
	TbOrder queryTbOrderById(Long id);

	// 实现根据订单创建的时间范围(例如查询3月26日这一天的)，查询所有支付类型为在线支付，而且已付款的订单
	List<TbOrder> queryTbOrderByDate(Map<String, Object> map);

	// 实现根据买家留言模糊查询订单
	List<TbOrder> queryTbOrderByBuyerMessage(String msg);

	// 实现根据订单id修改订单
	void updateTbOrderById(TbOrder tbOrder);

	// 实现根据订单创建的时间范围(例如查询3月26日这一天的)，修改所有支付类型是在线支付的，而且未付款的，把订单状态修改为交易关闭
	void updateTbOrderByDate(Map<String, Object> map);

	// 实现根据id删除订单
	void deleteTbOrderById(Long id);

}
