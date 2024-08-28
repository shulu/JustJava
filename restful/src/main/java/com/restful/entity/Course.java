package com.restful.entity;

import java.beans.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
