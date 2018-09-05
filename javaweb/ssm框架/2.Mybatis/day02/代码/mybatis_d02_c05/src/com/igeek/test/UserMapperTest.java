package com.igeek.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeek.ssm.mapper.UserMapper;
import com.igeek.ssm.po.User;
import com.igeek.ssm.po.UserExample;

public class UserMapperTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	}

	@Test
	public void testInsert() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = new User();
		user.setUsername("司马懿");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("三国");

		userMapper.insert(user);
	}

	@Test
	public void testSelectByExample() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		// 创建User对象扩展类，用户设置查询条件
		UserExample example = new UserExample();
		example.createCriteria().andUsernameLike("%张%");

		// 查询数据
		List<User> list = userMapper.selectByExample(example);

		System.out.println(list.size());
	}

	@Test
	public void testSelectByPrimaryKey() {
		// 获取Mapper
		UserMapper userMapper = this.context.getBean(UserMapper.class);

		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}
}

