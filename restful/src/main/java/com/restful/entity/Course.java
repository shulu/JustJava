/*
 * @Author: shulu
 * @Date: 2024-08-28 21:47:31
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-28 22:55:05
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\entity\Course.java
 */
package com.restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    @Column(name = "coursename", nullable = false, length = 30)
    private String coursename;

    @Column(name = "coursescore")
    private int coursescore;

    @Column(name = "coursetime")
    private int coursetime;

    @Column(name = "coursetype")
    private String coursetype;

    // 备注 数据库中无对应列
    @Transient
    private String description;
}
