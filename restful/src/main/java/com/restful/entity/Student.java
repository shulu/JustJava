/*
 * @Author: shulu
 * @Date: 2024-08-28 15:46:47
 * @LastEditors: shulu
 * @LastEditTime: 2024-09-02 15:51:16
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\entity\Student.java
 */
package com.restful.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "studentname")
        private String studentname;

        @Column(name = "gender")
        private String gender;

        @Column(name = "age")
        private int age;

        // 一对一关联
        @OneToOne(
                        // 级联操作
                        cascade = CascadeType.ALL,
                        // 延迟加载
                        fetch = FetchType.LAZY,
                        // 被关联的另一方实体
                        targetEntity = LibraryCard.class)
        @JoinColumn(
                        // 外键列
                        name = "libraryid",
                        // 将外键设置为唯一约束
                        unique = true,
                        // 主表的主键
                        referencedColumnName = "id")
        private LibraryCard libraryCard;

        @ManyToOne
        @JsonBackReference
        private Classes classes;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "course_id") })
        private List<Course> courseList;

        @ManyToOne
        private Classinfo classinfo;

        public Student(String studentname, String gender, int age) {
                this.studentname = studentname;
                this.gender = gender;
                this.age = age;
        }
}
