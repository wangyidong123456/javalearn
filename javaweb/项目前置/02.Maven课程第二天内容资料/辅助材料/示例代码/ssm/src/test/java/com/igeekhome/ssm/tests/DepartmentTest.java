package com.igeekhome.ssm.tests;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.igeekhome.ssm.dao.DepartmentMapper;
import com.igeekhome.ssm.domain.Department;

public class DepartmentTest {
	@Test
	public void testFindEmployeeById(){
		//加载配置文件
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml", "spring-mybatis.xml"});
		//获取dao
		DepartmentMapper departmentMapper = applicationContext.getBean(DepartmentMapper.class);
		//查询数据
		Department department = departmentMapper.selectByPrimaryKey(10);
		//查看数据
		System.out.println(department.getDname());
		//关闭上下文
		applicationContext.close();
	}
}