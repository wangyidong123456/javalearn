package com.igeek.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mapper.UserMapper;
import com.igeek.pojo.Order;
import com.igeek.pojo.OrderUser;
import com.igeek.pojo.User;
import com.igeek.vo.QueryVo;

public class TestOne2One {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void init() throws Exception {
		// 创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		// 加载SqlMapConfig.xml配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		// 创建SqlsessionFactory
		this.sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
	}
	
	
	
	
	@Test
	public void queryByUsername(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<OrderUser> orderUsers = mapper.queryOne2One();
		for (OrderUser orderUser : orderUsers) {
			System.out.println(orderUser);
		}
		session.close();
	}
	
	
	@Test
	public void testOne2One2(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<Order> orders = mapper.queryOrderUserResultMap();
		for (Order order : orders) {
			System.out.println(order);
		}
		session.close();
	}
	
		

}
