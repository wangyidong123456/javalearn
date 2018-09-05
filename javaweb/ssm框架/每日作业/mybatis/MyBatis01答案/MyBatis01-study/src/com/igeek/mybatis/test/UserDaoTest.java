package com.igeek.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mybatis.dao.UserDao;
import com.igeek.mybatis.dao.impl.UserDaoImpl;
import com.igeek.mybatis.pojo.User;

public class UserDaoTest {

	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		this.userDao = new UserDaoImpl(sqlSessionFactory);
	}

	@Test
	public void testQueryUserById() {
		User user = this.userDao.queryUserById(1);
		System.out.println(user);
	}

	@Test
	public void testQueryUserByUserName() {
		List<User> list = this.userDao.queryUserByUserName("明");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testSaveUser() {
		User user = new User();

		user.setUsername("张小三");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("湖北");

		this.userDao.saveUser(user);
	}

	@Test
	public void testUpdateUser() {
		User user = new User();

		user.setUsername("张小三");
		user.setAddress("北京");

		this.userDao.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		this.userDao.deleteUserById(1);
	}
}
