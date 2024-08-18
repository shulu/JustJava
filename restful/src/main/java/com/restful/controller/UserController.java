/*
 * @Author: shulu
 * @Date: 2024-08-08 17:36:43
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-18 23:08:46
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\controller\UserController.java
 */
package com.restful.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restful.entity.ResponseData;
import com.restful.entity.User;
import com.restful.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User操作接口")
@RestController
@RequestMapping("/users")
@SuppressWarnings("rawtypes")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseData addUser(@RequestBody User user) {
        System.out.println("新增用户信息:" + user);
        userService.addUser(user);
        return new ResponseData<>("200", null, true, null);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteUser(@PathVariable int id) {
        System.out.println("删除用户ID" + id);
        userService.deleteUser(id);
        return new ResponseData<>("200", null, true, null);
    }

    @PutMapping("")
    public ResponseData updateUser(@RequestBody User user) {
        System.out.println("修改后的用户信息:" + user);
        userService.updateUser(user);
        return new ResponseData<>("200", null, true, null);
    }

    @GetMapping("/{id}")
    public ResponseData getUser(@PathVariable int id) {
        System.out.println("查找用户信息 ID:" + id);
        User user = userService.findUserById(id);
        return new ResponseData<>("200", null, true, user);
    }

    @Operation(summary = "根据姓名查找用户对象", description = "根据姓名查找用户对象对象")
    @RequestMapping(value = "/findByName", method = { RequestMethod.POST, RequestMethod.GET })
    @Parameters({ @Parameter(name = "username", description = "用户名") })
    // @GetMapping("/{name}")
    public ResponseData getUser(@PathVariable String name) {
        System.out.println("查找用户信息 name:" + name);
        User user = userService.findUserByName(name);
        return new ResponseData<>("200", null, true, user);
    }

    @Operation(summary = "获取所有对象", description = "获取所有用户, 无需参数")
    @RequestMapping(value = "/findAllUsers", method = { RequestMethod.POST, RequestMethod.GET })
    // @GetMapping("")
    public ResponseData getUsers() {
        System.out.println("查找所有用户");
        Map<Integer, User> users = userService.findAllUsers();
        return new ResponseData<>("200", null, true, users);
    }
}
