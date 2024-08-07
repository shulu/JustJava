/*
 * @Author: shulu
 * @Date: 2024-08-07 15:54:19
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-07 16:15:16
 * @Description: file content
 * @FilePath: \JustJava\helloworld\helloworld\src\main\java\com\helloworld\TestController.java
 */
package com.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private  String user;

    @Value("${db.password}")
    private  String password;

    @RequestMapping("/test")
    public String test() {
        String str = "URL:"+url+"user:"+user+"password:"+password;
        return str;
    }
    
}
