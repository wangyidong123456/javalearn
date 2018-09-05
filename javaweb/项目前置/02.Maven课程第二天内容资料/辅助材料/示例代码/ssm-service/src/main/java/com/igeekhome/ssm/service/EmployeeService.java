package com.igeekhome.ssm.service;

import com.igeekhome.ssm.domain.Employee;

public interface EmployeeService {
	int deleteByPrimaryKey(Integer empno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}
