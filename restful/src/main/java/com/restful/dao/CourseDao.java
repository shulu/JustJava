package com.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.entity.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {

}
