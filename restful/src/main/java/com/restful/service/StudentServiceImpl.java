package com.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.entity.Student;
import com.restful.repository.StudentMapper;

@Service
public class StudentServiceImpl implements StudentServiceMyBatis {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findStudent(int id) {
        return studentMapper.findStudent(id);
    }

    @Override
    public Student findStudentById(int id) {
        return studentMapper.findStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }
}
