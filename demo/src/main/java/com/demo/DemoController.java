/*
 * @Author: shulu
 * @Date: 2024-08-08 15:52:41
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-08 15:52:44
 * @Description: file content
 * @FilePath: \JustJava\demo\src\main\java\com\demo\DemoController.java
 */
package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    
}
