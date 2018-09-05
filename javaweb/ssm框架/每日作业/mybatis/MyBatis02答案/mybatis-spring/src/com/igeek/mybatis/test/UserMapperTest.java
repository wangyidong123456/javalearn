package com.igeek.mybatis.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.mybatis.mapper.UserMapper;
import com.igeek.mybatis.pojo.QueryVo;
import com.igeek.mybatis.pojo.User;

public class UserMapperTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testQueryUserById() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = userMapper.queryUserById(1);
		System.out.println(user);
	}

	@Test
	public void testQueryUserByUsername() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		List<User> list = userMapper.queryUserByUsername("张");

		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testSaveUser() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = new User();
		user.setUsername("曹操");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("三国");

		userMapper.saveUser(user);
		System.out.println(user);
	}

	@Test
	public void testQueryUserBySexAndUsername() {
		// 获取Mapper
		UserMapper userMapper = context.getBean(UserMapper.class);

		User user = new User();
		user.setSex("1");
		user.setUsername("关");

		List<User> list = userMapper.queryUserBySexAndUsername(user);

		for (User u : list) {
			System.out.println(u);
		}
	}

	@Test
	public void testQueryUserByIds() {
		// 获取Mapper
		UserMapper userMapper = context.getBean(UserMapper.class);

		List<Integer> ids = new ArrayList<>();
		ids.add(27);
		ids.add(28);
		ids.add(31);
		ids.add(32);

		QueryVo queryVo = new QueryVo();
		queryVo.setIds(ids);

		List<User> list = userMapper.queryUserByIds(queryVo);

		for (User u : list) {
			System.out.println(u);
		}
	}

	@Test
	public void testQueryUserOrder() {
		// 获取Mapper
		UserMapper userMapper = context.getBean(UserMapper.class);

		List<User> list = userMapper.queryUserOrder();

	}
}
