package com.igeek.mybatis.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.igeek.mybatis.mapper.UserMapper;
import com.igeek.mybatis.pojo.QueryVo;
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
	public void testQueryUserByQueryVo() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		// 获取Mapper动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 执行新增
		User user = new User();
		user.setUsername("张");

		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);

		List<User> list = userMapper.queryUserByQueryVo(queryVo);

		for (User u : list) {
			System.out.println(u);
		}

		// 释放资源
		sqlSession.close();
	}

	@Test
	public void testQueryUserCount() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 获取Mapper动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 执行新增
		int count = userMapper.queryUserCount();

		System.out.println(count);

		// 释放资源
		sqlSession.close();
	}

	@Test
	public void testQueryUserBySexAndUsername() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 获取Mapper动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 执行新增
		User user = new User();
		user.setSex("1");
		user.setUsername("关");

		List<User> list = userMapper.queryUserBySexAndUsername(user);

		for (User u : list) {
			System.out.println(u);
		}

		// 释放资源
		sqlSession.close();
	}

	@Test
	public void testQueryUserByIds() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 获取Mapper动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 执行新增
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

		// 释放资源
		sqlSession.close();
	}

	@Test
	public void testQueryUserOrder() {
		// 获取sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		// 获取Mapper动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 执行新增
		List<User> list = userMapper.queryUserOrder();

		// 释放资源
		sqlSession.close();
	}
}
