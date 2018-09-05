package com.igeek.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mapper.OrderMapper;
import com.igeek.mapper.UserMapper;
import com.igeek.pojo.Order;
import com.igeek.pojo.User;
import com.igeek.vo.QueryVo;

public class TestOrderMapper {
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
	public void queryOrderAll(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		List<Order> orders = mapper.queryOrderAll();
		for (Order order : orders) {
			System.out.println(order);
		}
		session.close();
	}
	
	
	
	
	
	
	

}
