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

public class TestOne2Many {
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
	public void testOne2Many(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.queryUserOrder();
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	
	
		

}
