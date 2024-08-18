/*
 * @Author: shulu
 * @Date: 2024-08-10 19:51:58
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-18 22:53:09
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\service\UserService.java
 */
package com.restful.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.restful.entity.User;

@Service
public class UserService {

    private final static Map<Integer, User> users = new HashMap<>();
    static {
        users.put(1, new User(1, "张三", "123"));
        users.put(2, new User(2, "李四", "1234"));
    }

    private final static List<User> list = Arrays.asList(
            new User(1, "张三", "123"),
            new User(2, "李四", "1234"));

    public static Map<Integer, User> findAllUsers() {
        return users;
    }

    public static User findUserById(int id) {
        return users.get(id);
    }

    public static User findUserByName(String name) {
        for (User user : list) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public static void addUser(User user) {
        users.put(user.getId(), user);
    }

    public static void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public static void deleteUser(int id) {
        users.remove(id);
    }
}
