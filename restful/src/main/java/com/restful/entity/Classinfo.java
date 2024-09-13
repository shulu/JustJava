package com.restful.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classinfo {

    private int classno;

    private String classname;

    private List<Student> students;

}
