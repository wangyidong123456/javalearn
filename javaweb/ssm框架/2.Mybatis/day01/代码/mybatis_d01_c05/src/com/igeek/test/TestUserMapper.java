package com.igeek.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.dao.UserMapper;
import com.igeek.pojo.User;

public class TestUserMapper {
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
	public void queryUserById(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.queryUserById(1);
		System.out.println(user);
		session.close();
	}
	
	@Test
	public void queryByUsername(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> user = mapper.queryUserByUsername("张");
		for (User user2 : user) {
			System.out.println(user2);
		}
		session.close();
	}
	
	
	@Test
	public void testSaveUser(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("范冰冰");
		
		mapper.saveUser(user);
		session.commit();
		session.close();
	}
	
	

}
