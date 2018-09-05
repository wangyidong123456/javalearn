package com.igeekhome.ssm.tests;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeekhome.ssm.dao.EmployeeMapper;
import com.igeekhome.ssm.domain.Employee;

public class EmployeeTest {
	
	@Test
	public void testFindEmployeeById(){
		//加载配置文件
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mybatis.xml"});
		//获取dao
		EmployeeMapper employeeMapper = applicationContext.getBean(EmployeeMapper.class);
		//查询数据
		Employee employee = employeeMapper.selectByPrimaryKey(7369);
		//查看数据
		System.out.println(employee.getEname());
		//关闭上下文
		applicationContext.close();
	}
}
