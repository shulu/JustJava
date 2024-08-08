/*
 * @Author: shulu
 * @Date: 2024-08-07 15:22:16
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-08 16:29:32
 * @Description: file content
 * @FilePath: \JustJava\demo\src\test\java\com\demo\UserTest.java
 */
package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {
    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}
