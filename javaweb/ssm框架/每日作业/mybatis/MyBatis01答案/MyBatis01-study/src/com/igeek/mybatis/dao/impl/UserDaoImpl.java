package com.igeek.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.igeek.mybatis.dao.UserDao;
import com.igeek.mybatis.pojo.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User queryUserById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("queryUserById", id);

		sqlSession.close();
		return user;
	}

	@Override
	public List<User> queryUserByUserName(String userName) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("queryUserByUserName", userName);

		sqlSession.close();
		return list;
	}

	@Override
	public void saveUser(User user) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.insert("saveUser", user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void updateUser(User user) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.update("updateUser", user);

		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUserById(int id) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.insert("deleteUserById", 38);

		sqlSession.commit();
		sqlSession.close();
	}
}
