package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.entity.Employee;
import com.restful.repository.EmployeeMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee findEmployeeById(int empno) {
        return employeeMapper.findEmployeeById(empno);
    }

    @Override
    public List<Employee> findEmployeeSalaryLevel() {
        return employeeMapper.findEmployeeSalarylevel();
    }

    @Override
    public Employee findLeaderAndEmps(int empno) {
        return employeeMapper.findLeaderAndEmps(empno);
    }
}
