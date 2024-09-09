/*
 * @Author: shulu
 * @Date: 2024-08-27 21:42:03
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-30 15:53:22
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\service\StudentService.java
 */
package com.restful.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.restful.dao.StudentDao;
import com.restful.dao.StudentJPARepository;
import com.restful.dao.StudentRepository;
import com.restful.entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentJPARepository studentJPARepository;

    @Autowired
    private StudentDao studentDao;

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

    public List<Student> findAllStudentsJPA() {
        return studentJPARepository.findAll();
    }

    public Student findStudentByIdJPA(int id) {
        return studentJPARepository.findById(id).orElse(new Student());
    }

    public List<Student> searchStudents(Student student) {

        Specification<Student> spec;
        spec = (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            // List<Predicate> predicates = new ArrayList<Predicate>();
            List<Predicate> predicates = new ArrayList<>();
            if (null != student.getStudentname() && !"".equals(student.getStudentname())) {
                predicates.add(criteriaBuilder.like(root.get("studentname").as(String.class),
                        "%" + student.getStudentname() + "%"));
            }
            if (null != student.getGender() && !"".equals(student.getGender())) {
                predicates.add(criteriaBuilder.equal(root.get("gender").as(String.class), student.getGender()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return studentDao.findAll(spec);
    }
}
