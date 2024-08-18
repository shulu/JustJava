/*
 * @Author: shulu
 * @Date: 2024-08-18 21:34:12
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-18 21:34:14
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\controller\ThymeleafController.java
 */
package com.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("username", "admin");
        return "index";
    }
}
