package com.igeekhome.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igeekhome.ssm.domain.Employee;
import com.igeekhome.ssm.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String emp(){
		return "employee";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String findEmployeeByEmpno(int empno,ModelMap map){
		Employee employee = employeeService.selectByPrimaryKey(empno);
		map.put("employee", employee);
		return "employee_info";
	}
}