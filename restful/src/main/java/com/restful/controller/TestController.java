/*
 * @Author: shulu
 * @Date: 2024-08-10 16:58:31
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-11 15:01:04
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\controller\TestController.java
 */
package com.restful.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    // @CrossOrigin(value = "http://localhost:8081",maxAge=3600, allowedHeaders =
    // "*")
    @GetMapping("/getMsg")
    public String getMSg() {
        return "GET SUCCESS";
    }

    // @CrossOrigin(value = "http://localhost:8081",maxAge=3600, allowedHeaders =
    // "*")
    @DeleteMapping("/delMsg")
    public String delMsg() {
        return "DELETE SUCCESS";
    }

    @GetMapping("/test4")
    public String test4() {
        int i = 1 / 0;
        return "FALSE";
    }

}
