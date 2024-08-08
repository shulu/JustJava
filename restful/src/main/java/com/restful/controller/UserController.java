/*
 * @Author: shulu
 * @Date: 2024-08-08 17:36:43
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-08 17:50:47
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\controller\UserController.java
 */
package com.restful.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.entity.User;


@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("")
    public String addUser(@RequestBody  User user) {
        System.out.println("新增用户信息:" + user);
        return "新增用户成功";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("删除用户ID" + id);
        return "删除用户成功";
    }

}
