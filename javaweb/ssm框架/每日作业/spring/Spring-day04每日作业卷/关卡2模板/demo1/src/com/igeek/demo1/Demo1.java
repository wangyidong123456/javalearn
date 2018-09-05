package com.igeek.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试方法
 * @author Administrator
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class Demo1 {
	
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void run1(){
		
		
	}

}
