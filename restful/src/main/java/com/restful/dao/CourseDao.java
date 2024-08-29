package com.restful.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

    public List<Course> findByCoursescoreAndCoursetype(int coursescore, String coursetype);

    public List<Course> findByCoursescoreOrCoursetype(int coursescore, String coursetype);

    public List<Course> findByCoursetimeBetween(int start, int end);

    public List<Course> findByCoursetimeLessThan(int coursetime);

    public List<Course> findByCoursenameContains(String coursename);
}
