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

    public List<Course> findByCoursescoreAndCoursetype(int coursescore, String coursetype) {
        return courseDao.findByCoursescoreAndCoursetype(coursescore, coursetype);
    }

    public List<Course> findByCoursescoreOrCoursetype(int coursescore, String coursetype) {
        return courseDao.findByCoursescoreOrCoursetype(coursescore, coursetype);
    }

    public List<Course> findByCoursetimeBetween(int start, int end) {
        return courseDao.findByCoursetimeBetween(start, end);
    }

    public List<Course> findByCoursetimeLessThan(int coursetime) {
        return courseDao.findByCoursetimeLessThan(coursetime);
    }

    public List<Course> findByCoursenameContains(String coursename) {
        return courseDao.findByCoursenameContains(coursename);
    }

    public List<Course> selectCourses1(int coursescore) {
        return courseDao.selectCourses1(coursescore);
    }

    public List<Course> selectCourses2(int coursescore, int coursetime) {
        return courseDao.selectCourses2(coursescore, coursetime);
    }

    public List<Course> selectCourses3(int coursescore) {
        return courseDao.selectCourses3(coursescore);
    }

    public List<Course> selectCourses4(int coursescore) {
        return courseDao.selectCourses4(coursescore);
    }

    public List<Course> selectCourses5(String coursename) {
        return courseDao.selectCourses5(coursename);
    }

    public void updateCourse(String coursename, int coursescore, int coursetime, String coursetype,
            int courseid) {
        courseDao.updateCourse(coursename, coursescore, coursetime, coursetype, courseid);
    }

}
