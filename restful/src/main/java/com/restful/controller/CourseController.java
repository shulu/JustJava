package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return new ModelAndView();
    }

}
