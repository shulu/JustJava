package com.restful.service;

import com.restful.entity.Student;

public interface StudentServiceMyBatis {

    public Student findStudent(int id);

    public void updateStudent(Student student);

    public Student findStudentById(int id);

}
