package com.restful.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "用户User类", description = "描述用户User信息")
public class User {

    @Schema(name = "用户ID")
    private int id;

    @Schema(name = "用户名")
    private String username;

    @Schema(name = "用户密码")
    private String password;

    // public int getId() {
    // return id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    // public String getUsername() {
    // return username;
    // }

    // public void setUsername(String username) {
    // this.username = username;
    // }

    // public String getPassword() {
    // return password;
    // }

    // public void setPassword(String password) {
    // this.password = password;
    // }

    // @Override
    // public String toString() {
    // // return "1";
    // return "User{" + "username=" + username + "password=" + password + "id=" + id
    // + "}";
    // }
}
