/*
 * @Author: shulu
 * @Date: 2024-08-30 16:42:20
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-30 16:42:23
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\controller\ClassesController.java
 */
package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.restful.entity.Classes;
import com.restful.service.ClassesService;

@Controller
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping("/findAllClasses")
    public ModelAndView findAllClasses() {
        ModelAndView mv = new ModelAndView();
        List<Classes> classesList = classesService.findAllClasses();
        mv.addObject("classesList", classesList);
        mv.setViewName("classesList");
        return mv;
    }

}
