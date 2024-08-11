package com.restful.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restful.dao.UserDao;
import com.restful.entity.ResponseData;
import com.restful.entity.User;

@RestController
@RequestMapping("/exception")
@SuppressWarnings("rawtypes")
public class ExceptionController {

    @GetMapping("/c1")
    public ResponseData c1() {
        int[] arr = { 1, 2, 3 };
        arr = null;
        System.out.println(arr[0]);
        Map<Integer, User> users = UserDao.findAllUsers();
        return new ResponseData<>("200", null, true, users);
    }

    @GetMapping("/c2")
    public ResponseData c2() {
        int[] arr = { 1, 2, 3 };
        System.out.println(arr[3]);
        Map<Integer, User> users = UserDao.findAllUsers();
        return new ResponseData<>("200", null, true, users);
    }

    @GetMapping("/c3")
    public ResponseData c3() {
        int[] arr = { 1, 2, 3 };
        int i = 10 / 0;
        Map<Integer, User> users = UserDao.findAllUsers();
        return new ResponseData<>("200", null, true, users);
    }

}
