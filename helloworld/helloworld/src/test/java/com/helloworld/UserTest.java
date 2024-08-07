/*
 * @Author: shulu
 * @Date: 2024-08-07 15:22:16
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-07 15:48:07
 * @Description: file content
 * @FilePath: \JustJava\helloworld\helloworld\src\test\java\com\helloworld\UserTest.java
 */
package com.helloworld;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {
    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}
