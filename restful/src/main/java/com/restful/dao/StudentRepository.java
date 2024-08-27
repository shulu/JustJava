package com.restful.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restful.entity.Student;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate JDBCTemplate;

    public int addStudent(Student student) {
        return JDBCTemplate.update("insert into student(studentname, gender, age) values(?,?,?)",
                student.getStudentname(), student.getGender(), student.getAge());
    }

    public int deleteStudent(int id) {
        return JDBCTemplate.update("delete from student where id = ?", id);
    }

    public int updateStudent(Student student) {
        return JDBCTemplate.update("update student set studentname = ?, gender = ?, age = ? where id = ?",
                student.getStudentname(), student.getGender(), student.getAge(), student.getId());
    }

    public List<Student> findAllStudents() {
        return JDBCTemplate.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
    }

    public Student findStudentById(int id) {
        return JDBCTemplate.queryForObject("select * from student where id=?",
                new BeanPropertyRowMapper<>(Student.class), id);
    }
}
