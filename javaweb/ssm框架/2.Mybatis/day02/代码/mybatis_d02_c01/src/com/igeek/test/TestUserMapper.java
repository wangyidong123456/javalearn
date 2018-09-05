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
import com.igeek.pojo.User;
import com.igeek.vo.QueryVo;

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
	public void queryByUsername(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		User u = new User();
		u.setUsername("张");
		queryVo.setUser(u);
		
		List<User> user = mapper.queryUserByQueryVo(queryVo);
		for (User user2 : user) {
			System.out.println(user2);
		}
		session.close();
	}
	
	
	@Test
	public void queryCount(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		int count = mapper.queryUserCount();
		System.out.println("count:"+count);
		session.close();
	}
	
	
	@Test
	public void querWhere(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setSex("1");
		user.setUsername("张");
		List<User> users = mapper.queryUserByWhere(user);
		for (User user2 : users) {
			System.out.println(user2);
		}
		session.close();
	}
	
	
	@Test
	public void querIds(){
		SqlSession session = sqlSessionFactory.openSession();
		//获取接口的代理类
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(24);
		queryVo.setIds(ids);
		
		List<User> users = mapper.queryUserByIds(queryVo);
		for (User user2 : users) {
			System.out.println(user2);
		}
		session.close();
	}
	
	
	
	
	
	
	
	

}
