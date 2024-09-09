package com.restful;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restful.dao.CourseDao;
import com.restful.dao.StudentDao;
import com.restful.entity.Course;
import com.restful.entity.Student;

@SpringBootTest
public class Test1 {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CourseDao courseDao;

    @Test
    public void addStudentAndCourse() {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course("数据结构", 2, 40, "选修", "aaa");
        Course course2 = new Course("操作系统", 4, 40, "必修", "aaa");
        courses.add(course1);
        courses.add(course2);
        courseDao.save(course1);
        courseDao.save(course2);

        Student student1 = new Student("Smith", "男", 20);
        Student student2 = new Student("Alice", "女", 19);
        students.add(student1);
        students.add(student2);

        course1.setStudentList(students);
        course2.setStudentList(students);

        student1.setCourseList(courses);
        student2.setCourseList(courses);

        studentDao.save(student1);
        studentDao.save(student2);

        System.out.println("保存成功！");
    }

}
