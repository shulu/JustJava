package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.restful.dao.CourseDao;
import com.restful.entity.Course;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> findAll() {
        return courseDao.findAll();
    }

    // 排序
    public List<Course> findAll(Sort sort) {
        return courseDao.findAll(sort);
    }

    // 分页
    public Page<Course> findAll(Pageable pageable) {
        return courseDao.findAll(pageable);
    }

    public Course findById(int courseid) {
        return courseDao.findById(courseid).orElse(new Course());
    }

    public void updateCourse(Course course) {
        courseDao.save(course);
    }

    public void addCourse(Course course) {
        courseDao.save(course);
    }

    public void deleteCourse(int courseid) {
        courseDao.deleteById(courseid);
    }
}