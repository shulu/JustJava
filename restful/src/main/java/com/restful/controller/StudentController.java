/*
 * @Author: shulu
 * @Date: 2024-08-27 21:46:56
 * @LastEditors: shulu
 * @LastEditTime: 2024-09-02 15:12:07
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\controller\StudentController.java
 */
package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.restful.dao.StudentJPARepository;
import com.restful.entity.Student;
import com.restful.service.StudentService;
import com.restful.service.StudentServiceMyBatis;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentJPARepository studentJPARepository;

    @Autowired
    private StudentServiceMyBatis studentServiceMyBatis;

    @GetMapping("/stus")
    public ModelAndView findAllStudents() {
        List<Student> stus = studentService.findAllStudents();
        ModelAndView mv = new ModelAndView();
        mv.addObject("stus", stus);
        mv.setViewName("stus");
        return mv;
    }

    @GetMapping("/stu/{id}")
    public ModelAndView findStudentById(@PathVariable("id") int id) {
        Student student = studentService.findStudentById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        System.out.println(student);
        mv.setViewName("student");
        return mv;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Student student) {
        // TODO: process POST request
        studentService.addStudent(student);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/stus");
        return mv;
    }

    @GetMapping("/addStudent")
    public String addStudent() {
        return "addStudent";
    }

    @GetMapping("/deleteStudent/{Id}")
    public ModelAndView deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/stus");
        return mv;
    }

    @GetMapping("/updateStudent/{id}")
    public ModelAndView toUpdateStudent(@PathVariable("id") int id) {
        Student student = studentService.findStudentById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("updateStudent");
        return mv;
    }

    @PostMapping("/updateStudent")
    public ModelAndView UpdateStudent(Student student) {
        // TODO: process POST request
        studentService.updateStudent(student);
        ModelAndView mv = new ModelAndView();
        System.out.println(student);
        mv.setViewName("redirect:/stus");
        return mv;
    }

    @GetMapping("/findAllPage")
    public ModelAndView findAll(@RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "size", defaultValue = "3") Integer size) {
        ModelAndView mv = new ModelAndView();
        Pageable pageable = PageRequest.of(start, size,
                Sort.by(Sort.Direction.DESC, "id"));
        Page<Student> page = studentJPARepository.findAll(pageable);
        mv.addObject("page", page);
        mv.setViewName("stusPage");
        return mv;
    }

    @GetMapping("/findStudentById/{id}")
    public ModelAndView findStudentByIdJPA(@PathVariable("id") int id) {
        Student student = studentService.findStudentByIdJPA(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("student");
        return mv;
    }

    @GetMapping("/findStudentClasses/{id}")
    public ModelAndView findStudentClasses(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        Student student = studentService.findStudentByIdJPA(id);
        System.out.println(student);
        mv.addObject("student", student);
        mv.setViewName("student2");
        return mv;
    }

    @GetMapping("/findStudentCourse")
    public ModelAndView findStudentCourse(int id) {
        ModelAndView mv = new ModelAndView();
        Student student = studentService.findStudentByIdJPA(id);
        mv.addObject("student", student);
        mv.setViewName("student3");
        return mv;
    }

    @GetMapping("/searchStudents")
    public ModelAndView searchStudents(Student student) {
        ModelAndView mv = new ModelAndView();
        List<Student> students = studentService.searchStudents(student);
        mv.addObject("students", students);
        mv.setViewName("students");
        return mv;
    }

    @GetMapping("/findAllStudentsNew")
    public ModelAndView findAllStudentsNew() {
        ModelAndView mv = new ModelAndView();
        List<Student> students = studentService.findAllStudentsJPA();
        mv.addObject("students", students);
        mv.setViewName("students");
        return mv;
    }

    @GetMapping("/toupdatestudent/{id}")
    public ModelAndView toUpdate(@PathVariable("id") int id) {
        Student student = studentServiceMyBatis.findStudent(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("updatestudentmb");
        return mv;
    }

    @GetMapping("/updatestu")
    public ModelAndView updateStudentMB(Student student) {
        System.out.println(student);
        studentServiceMyBatis.updateStudent(student);
        student = studentServiceMyBatis.findStudentById(student.getId());
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("updatestudentmb");
        return mv;
    }

    @GetMapping("/student/{id}")
    public ModelAndView findStudentByIdMB(@PathVariable("id") int id) {
        Student student = studentServiceMyBatis.findStudentById(id);
        System.out.println(student);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
        mv.setViewName("studentci");
        return mv;
    }

}
