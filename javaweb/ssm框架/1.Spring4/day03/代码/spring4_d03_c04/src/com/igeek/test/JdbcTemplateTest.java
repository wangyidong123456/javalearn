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
		//目标：使用jdbctemplate执行一段sql
		//1.构建数据源
		//spring内置了一个数据源
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///igeekspring");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		
//		PreparedStatement ps =null;
//		ps.execute(sql);
		//2.创建jdbctemplate实例
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		//等同于
//		jdbcTemplate.setDataSource(dataSource)
		
		//3.执行sql，创建表test001
		jdbcTemplate.execute("create table test001(id int,name varchar(20))");
		
	}
	
	//注入要测试bean
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testCreatetable(){
		jdbcTemplate.execute("create table test006(id int,name varchar(20))");
	}


}
