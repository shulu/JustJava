package com.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        // ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        // System.out.println(context.getBean(HelloController.class));
        // String[] beans = context.getBeanDefinitionNames();
        // System.out.println(beans.length);
        // for (Object bean : beans) {
        //     System.err.println(bean);
        // }
    }
}