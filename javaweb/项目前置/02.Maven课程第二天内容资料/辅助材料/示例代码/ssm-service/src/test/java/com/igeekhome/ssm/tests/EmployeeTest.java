package com.igeekhome.ssm.tests;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.igeekhome.ssm.domain.Employee;
import com.igeekhome.ssm.service.EmployeeService;

public class EmployeeTest {
	
	@Test
	public void testFindEmployeeById(){
		//加载配置文件
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mybatis.xml"});
		//获取dao
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		//查询数据
		Employee employee = employeeService.selectByPrimaryKey(7369);
		//查看数据
		System.out.println(employee.getEname());
		//关闭上下文
		applicationContext.close();
	}
}
