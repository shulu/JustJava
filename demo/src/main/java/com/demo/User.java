/*
 * @Author: shulu
 * @Date: 2024-08-08 15:59:11
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-08 15:59:13
 * @Description: file content
 * @FilePath: \JustJava\demo\src\main\java\com\demo\User.java
 */
package com.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
public class User {
    private String username;
    private String password;
    private String telephone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        // return "1";
        return "User{" + "username=" + username + "password=" + password + "telephone=" + telephone + "}";
    }
}
