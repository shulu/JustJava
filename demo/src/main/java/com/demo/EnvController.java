package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

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
