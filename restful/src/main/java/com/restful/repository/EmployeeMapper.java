package com.restful.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.restful.entity.Employee;

@Mapper
public interface EmployeeMapper {
    public Employee findEmployeeById(int empno);// 查找员工及其上司

    public List<Employee> findEmployeeSalarylevel();

    public Employee findLeaderAndEmps(int empno); // 查询员工及其下属
}
