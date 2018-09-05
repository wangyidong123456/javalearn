package com.igeek.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import com.igeek.pojo.User;

public class MybatisTest {
	
	private SqlSessionFactory factory= null;
	//
	@Before
	public void init(){
		//创建SqlSessionFactoryBuilder对象
		//用来连接数据库的配置文件，创建SqlSessionFactory对象
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//加载SqlMapConfig.xml配置文件
		try {
			InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
			//建立了连接池
			factory = builder.build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		//param1:执行sql的id
		User user = session.selectOne("queryById", 24);
		System.out.println(user);
		
		session.close();
	}
	
	
	@Test
	public void testQueryByName(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		//param1:执行sql的id
		List<User> users = session.selectList("queryByName", "%王%");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	
	@Test
	public void testSave(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		User user = new User();
		user.setUsername("冠希");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("上海");
		session.insert("insertUser", user);
		//提交
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testSaveUser(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		User user = new User();
		user.setUsername("鹿晗1");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("上海");
		int res =  session.insert("saveUser", user);
		System.out.println("id:"+res);
		
		System.out.println(user);
		//提交
		session.commit();
		
		session.close();
	}
	
	
	@Test
	public void testSaveUser1(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		User user = new User();
		user.setUsername("鹿晗1");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("上海");
//		String uuid =UUID.randomUUID().toString();
//		user.setUuid(uuid);
//		System.out.println(uuid);
		session.insert("saveUser1", user);
		
		System.out.println(user);
		//提交
		session.commit();
		
		session.close();
	}
	
	
	@Test
	public void testUpdate(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		User user = new User();
		user.setUsername("马蓉");
		user.setId(16);
		session.update("updateUser", user);
		
		//提交
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testDelete(){
		//创建SqlSession对象  相当于Connection
		SqlSession session = factory.openSession();
		//执行查询的sql  通过User.xml中的id定位dao要执行的sql
		session.delete("deleteUser", 16);
		
		//提交
		session.commit();
		
		session.close();
	}
	
	
}	
