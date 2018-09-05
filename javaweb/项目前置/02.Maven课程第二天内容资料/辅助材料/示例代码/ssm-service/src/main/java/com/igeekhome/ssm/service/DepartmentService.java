package com.igeekhome.ssm.service;

import com.igeekhome.ssm.domain.Department;

public interface DepartmentService {
	int deleteByPrimaryKey(Integer deptno);

	int insert(Department record);

	int insertSelective(Department record);

	Department selectByPrimaryKey(Integer deptno);

	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);
}
