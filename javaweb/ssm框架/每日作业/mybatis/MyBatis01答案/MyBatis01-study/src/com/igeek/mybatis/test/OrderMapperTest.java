package com.igeek.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mybatis.dao.OrderMapper;
import com.igeek.mybatis.pojo.Order;

public class OrderMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = builder.build(inputStream);

	}

	@Test
	public void testQueryOrderById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		Order order = orderMapper.queryOrderById(3);

		System.out.println(order);
		sqlSession.close();
	}

	@Test
	public void testQueryOrderByOrderName() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper userMapper = sqlSession.getMapper(OrderMapper.class);

		List<Order> list = userMapper.queryOrderByNote("价");

		for (Order order : list) {
			System.out.println(order);
		}
		sqlSession.close();
	}

	@Test
	public void testSaveOrder() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper userMapper = sqlSession.getMapper(OrderMapper.class);

		Order order = new Order();
		order.setNumber("1001");
		order.setUser_id(1);
		order.setCreatetime(new Date());
		order.setNote("活动价");

		userMapper.saveOrder(order);

		System.out.println(order);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateOrder() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper userMapper = sqlSession.getMapper(OrderMapper.class);

		Order order = new Order();
		order.setId(7);
		order.setNote("12344");

		userMapper.updateOrder(order);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteOrder() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper userMapper = sqlSession.getMapper(OrderMapper.class);

		userMapper.deleteOrderById(7);

		sqlSession.commit();
		sqlSession.close();
	}
}
