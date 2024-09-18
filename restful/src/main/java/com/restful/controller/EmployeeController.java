package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.restful.entity.Employee;
import com.restful.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ModelAndView findEmployeeById(@PathVariable("id") int id) {
        System.out.println(id);
        Employee employee = employeeService.findEmployeeById(id);
        System.out.println(employee);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        mv.setViewName("employee");
        return mv;
    }

    @GetMapping("/leaders/{id}")
    public ModelAndView findLeaderAndEmps(@PathVariable("id") int id) {
        Employee employee = employeeService.findLeaderAndEmps(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", employee);
        mv.setViewName("leader");
        return mv;
    }

    @GetMapping("/employees")
    public ModelAndView findEmployeeSalaryLevel() {
        List<Employee> employees = employeeService.findEmployeeSalaryLevel();
        ModelAndView mv = new ModelAndView();
        mv.addObject("employees", employees);
        mv.setViewName("emplist");
        return mv;
    }

}
