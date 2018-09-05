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

import com.igeek.mybatis.mapper.OrderMapper;
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
	public void testQueryOrderAll() {
		// 获取OrderMapper
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

		List<Order> list = orderMapper.queryOrderAll();

		for (Order order : list) {
			System.out.println(order);
		}

		sqlSession.close();
	}

}
