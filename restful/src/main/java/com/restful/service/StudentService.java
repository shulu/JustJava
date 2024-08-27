/*
 * @Author: shulu
 * @Date: 2024-08-27 21:42:03
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-27 21:42:06
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\service\StudentService.java
 */
package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dao.StudentRepository;
import com.restful.entity.Student;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public int addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public int deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    public int updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }
}
