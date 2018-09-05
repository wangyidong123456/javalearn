package com.igeekhome.ssm.dao;

import com.igeekhome.ssm.domain.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer deptno);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer deptno);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}