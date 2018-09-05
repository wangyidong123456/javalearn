package com.igeekhome.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeekhome.ssm.dao.EmployeeMapper;
import com.igeekhome.ssm.domain.Employee;
import com.igeekhome.ssm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer empno) {
		return employeeMapper.deleteByPrimaryKey(empno);
	}

	@Override
	public int insert(Employee record) {
		return employeeMapper.insert(record);
	}

	@Override
	public int insertSelective(Employee record) {
		return employeeMapper.insertSelective(record);
	}

	@Override
	public Employee selectByPrimaryKey(Integer empno) {
		return employeeMapper.selectByPrimaryKey(empno);
	}

	@Override
	public int updateByPrimaryKeySelective(Employee record) {
		return employeeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Employee record) {
		return employeeMapper.updateByPrimaryKey(record);
	}
	
	public List<Employee> selectAll(){
		return employeeMapper.selectAll();
	}
	

}
