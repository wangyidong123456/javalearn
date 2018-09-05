package com.igeekhome.ssm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.igeekhome.ssm.domain.Employee;
import com.igeekhome.ssm.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listEmp(ModelMap map){
		List<Employee> emps = employeeService.selectAll();
		map.addAttribute("employees", emps);
		return "employee";
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String addEmp(){
		return "add_employee";
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public void addEmpToDb(Employee employee,HttpServletResponse response){
		employeeService.insert(employee);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/delete")
	public void deleteEmp(int empno,HttpServletResponse response){
		employeeService.deleteByPrimaryKey(empno);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
