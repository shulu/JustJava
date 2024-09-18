package com.restful.service;

import java.util.List;

import com.restful.entity.Employee;

public interface EmployeeService {
    public Employee findEmployeeById(int empno);

    public List<Employee> findEmployeeSalaryLevel();

    public Employee findLeaderAndEmps(int empno);
}
