package com.igeekhome.ssm.tests;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igeekhome.ssm.dao.EmployeeMapper;
import com.igeekhome.ssm.domain.Employee;
import com.igeekhome.ssm.service.EmployeeService;

public class TestEmployee {
	
	@Test
	public void getEmployeeByEmpno(){
		//创建Spring的上下问对象
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml","spring-mybatis.xml");
		//获取mapper接口的对象
		EmployeeMapper employeeMapper = act.getBean(EmployeeMapper.class);
		//调用接口中的方法
		Employee employee = employeeMapper.selectByPrimaryKey(7369);
		
		System.out.println(employee.getEname());
		
		//关闭上下文
		act.close();
	}
	
	@Test
	public void getEmployeeByEmpno2(){
		//创建Spring的上下问对象
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml","spring-mybatis.xml");
		//获取mapper接口的对象
		EmployeeService employeeService = act.getBean(EmployeeService.class);
		//调用接口中的方法
		Employee employee = employeeService.selectByPrimaryKey(7499);
		
		System.out.println("编号为:7499的员工姓名为："+employee.getEname());
		
		//关闭上下文
		act.close();
	}
}
