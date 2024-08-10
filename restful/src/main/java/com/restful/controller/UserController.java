/*
 * @Author: shulu
 * @Date: 2024-08-08 17:36:43
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-10 20:58:16
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\controller\UserController.java
 */
package com.restful.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.dao.UserDao;
import com.restful.entity.ResponseData;
import com.restful.entity.User;

@RestController
@RequestMapping("/users")
@SuppressWarnings("rawtypes")
public class UserController {

    @PostMapping("")
    public ResponseData addUser(@RequestBody User user) {
        System.out.println("新增用户信息:" + user);
        UserDao.addUser(user);
        return new ResponseData<>("200", null, true, null);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteUser(@PathVariable int id) {
        System.out.println("删除用户ID" + id);
        UserDao.deleteUser(id);
        return new ResponseData<>("200", null, true, null);
    }

    @PutMapping("")
    public ResponseData updateUser(@RequestBody User user) {
        System.out.println("修改后的用户信息:" + user);
        UserDao.updateUser(user);
        return new ResponseData<>("200", null, true, null);
    }

    @GetMapping("/{id}")
    public ResponseData getUser(@PathVariable int id) {
        System.out.println("查找用户信息 ID:" + id);
        User user = UserDao.findUserById(id);
        return new ResponseData<>("200", null, true, user);
    }

    @GetMapping("")
    public ResponseData getUsers() {
        System.out.println("查找所有用户");
        Map<Integer, User> users = UserDao.findAllUsers();
        return new ResponseData<>("200", null, true, users);
    }
}
