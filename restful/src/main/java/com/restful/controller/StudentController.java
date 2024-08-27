package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restful.entity.Student;
import com.restful.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/stus")
    public ModelAndView findAllStudents() {
        List<Student> stus = studentService.findAllStudents();
        ModelAndView mv = new ModelAndView();
        mv.addObject("stus", stus);
        mv.setViewName("STUS");
        return mv;
    }

    @GetMapping("/stu/{id}")
    public ModelAndView findStudentById(@PathVariable("id") int id) {
        Student student = studentService.findStudentById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("student", student);
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

}
