/*
 * @Author: shulu
 * @Date: 2024-08-10 19:51:58
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-10 20:49:44
 * @Description: file content
 * @FilePath: \JustJava\restful\src\main\java\com\restful\dao\UserDao.java
 */
package com.restful.dao;

import java.util.HashMap;
import java.util.Map;

import com.restful.entity.User;

public class UserDao {

    private final static Map<Integer, User> users = new HashMap<>();
    static {
        users.put(1, new User(1, "张三", "123"));
        users.put(2, new User(2, "李四", "1234"));
    }

    public static Map<Integer, User> findAllUsers() {
        return users;
    }

    public static User findUserById(int id) {
        return users.get(id);
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
