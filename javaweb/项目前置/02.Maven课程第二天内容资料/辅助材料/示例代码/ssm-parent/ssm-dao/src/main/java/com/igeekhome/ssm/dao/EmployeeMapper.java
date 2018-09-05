package com.igeekhome.ssm.dao;

import com.igeekhome.ssm.domain.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}