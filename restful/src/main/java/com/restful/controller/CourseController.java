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

import com.restful.entity.Course;
import com.restful.service.CourseService;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/updateCourse/{id}")
    public ModelAndView toupdateCourse(@PathVariable("id") int courseid) {
        ModelAndView mv = new ModelAndView();
        Course course = courseService.findById(courseid);
        mv.addObject("course", course);
        mv.setViewName("updateCourse");
        return mv;
    }

    @PostMapping("/updateCourse")
    public ModelAndView updateCourse(Course course) {
        // TODO: process POST request
        ModelAndView mv = new ModelAndView();
        courseService.updateCourse(course);
        mv.setViewName("redirect:findAll");
        return mv;
    }

    @PostMapping("/addCourse")
    public ModelAndView addCourse(Course course) {
        // TODO: process POST request
        ModelAndView mv = new ModelAndView();
        courseService.addCourse(course);
        mv.setViewName("redirect:/findAll");
        return mv;
    }

    @GetMapping("/addCourse")
    public String addCourse() {
        return "addCourse";
    }

    @GetMapping("/deleteCourse/{id}")
    public ModelAndView deleteCourse(@PathVariable("id") int courseid) {
        ModelAndView mv = new ModelAndView();
        courseService.deleteCourse(courseid);
        mv.setViewName("redirect:findAll");
        return mv;
    }

    @GetMapping("/findAll1")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<Course> courselist = courseService.findAll();
        mv.addObject("courses", courselist);
        mv.setViewName("courses");
        return mv;
    }

    @GetMapping("/findAll2")
    public ModelAndView findAll2() {
        ModelAndView mv = new ModelAndView();
        List<Course> courselist = courseService.findAll(Sort.by(Sort.Direction.DESC, "coursescore"));
        mv.addObject("courses", courselist);
        mv.setViewName("courses");
        return mv;
    }

    @GetMapping("/findAll3")
    public ModelAndView findAll(@RequestParam(value = "start", defaultValue = "0") Integer start,
            @RequestParam(value = "size", defaultValue = "3") Integer size) {
        ModelAndView mv = new ModelAndView();
        Pageable pageable = PageRequest.of(start, size, Sort.by(Sort.Direction.DESC, "courseid"));
        Page<Course> page = courseService.findAll(pageable);
        mv.addObject("page", page);
        mv.setViewName("course");
        return mv;
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("Id") int courseid) {
        ModelAndView mv = new ModelAndView();
        Course course = courseService.findById(courseid);
        mv.addObject("course", course);
        mv.setViewName("course");
        return mv;
    }

}
