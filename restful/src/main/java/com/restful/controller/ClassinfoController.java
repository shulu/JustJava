package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.restful.entity.Classinfo;
import com.restful.service.ClassinfoService;

@Controller
public class ClassinfoController {

    @Autowired
    private ClassinfoService classinfoService;

    @GetMapping("/classinfo/{id}")
    public ModelAndView findClassinfoById(@PathVariable("id") int classno) {
        System.out.println(classno);
        Classinfo classinfo = classinfoService.findClassinfoById(classno);
        System.out.println(classinfo);
        ModelAndView mv = new ModelAndView();
        mv.addObject("classinfo", classinfo);
        mv.setViewName("classdetail");
        return mv;
    }

}
