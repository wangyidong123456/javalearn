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

import com.igeek.mybatis.dao.UserMapper;
import com.igeek.mybatis.pojo.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		this.sqlSessionFactory = builder.build(inputStream);

	}

	@Test
	public void testQueryUserById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = userMapper.queryUserById(1);

		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testQueryUserByUserName() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		List<User> list = userMapper.queryUserByUserName("张");

		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.close();
	}

	@Test
	public void testSaveUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = new User();

		user.setUsername("拉莫斯");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("披甲龙龟");
		userMapper.saveUser(user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testUpdateUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		User user = new User();
		user.setUsername("拉莫斯");
		user.setAddress("披甲龙龟");

		userMapper.updateUser(user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		userMapper.deleteUserById(39);

		sqlSession.commit();
		sqlSession.close();
	}
}
