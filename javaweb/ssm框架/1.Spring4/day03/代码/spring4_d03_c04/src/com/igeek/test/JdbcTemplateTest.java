package com.igeek.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JdbcTemplateTest {
	
	@Test
	public void test(){
		//Ŀ�꣺ʹ��jdbctemplateִ��һ��sql
		//1.��������Դ
		//spring������һ������Դ
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///igeekspring");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		
//		PreparedStatement ps =null;
//		ps.execute(sql);
		//2.����jdbctemplateʵ��
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//��ͬ��
//		jdbcTemplate.setDataSource(dataSource)
		
		//3.ִ��sql��������test001
		jdbcTemplate.execute("create table test001(id int,name varchar(20))");
		
	}
	
	//ע��Ҫ����bean
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCreatetable(){
		jdbcTemplate.execute("create table test006(id int,name varchar(20))");
	}


}
