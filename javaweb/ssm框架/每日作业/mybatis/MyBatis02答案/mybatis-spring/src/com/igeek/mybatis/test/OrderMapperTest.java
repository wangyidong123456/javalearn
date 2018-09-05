package com.igeek.mybatis.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.mybatis.mapper.OrderMapper;
import com.igeek.mybatis.pojo.Order;
import com.igeek.mybatis.pojo.OrderUser;

public class OrderMapperTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testQueryOrderCount() {
		// 获取OrderMapper
		OrderMapper orderMapper = context.getBean(OrderMapper.class);

		int count = orderMapper.queryOrderCount();

		System.out.println(count);
	}

	@Test
	public void testQueryOrderAll() {
		// 获取OrderMapper
		OrderMapper orderMapper = context.getBean(OrderMapper.class);

		List<Order> list = orderMapper.queryOrderAll();

		for (Order order : list) {
			System.out.println(order);
		}
	}

	@Test
	public void testQueryOrderUser() {
		// 获取OrderMapper
		OrderMapper orderMapper = context.getBean(OrderMapper.class);

		List<OrderUser> list = orderMapper.queryOrderUser();
	}

	@Test
	public void testQueryOrder() {
		// 获取OrderMapper
		OrderMapper orderMapper = context.getBean(OrderMapper.class);

		List<Order> list = orderMapper.queryOrder();
	}
}
