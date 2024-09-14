package com.restful.repository;

import org.apache.ibatis.annotations.Mapper;

import com.restful.entity.Student;

@Mapper
public interface StudentMapper {

    public Student findStudent(int id);

    public void updateStudent(Student student);

    public Student findStudentById(int id);
}
