package com.restful.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int empno;
    private String ename;
    private String job;
    // private int leaderid;
    private int salary;
    // 上司
    private Employee leader;
    // 下属员工
    private List<Employee> employees;
    // 工资等级
    private String level;
}
