package com.restful.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restful.entity.Course;

import jakarta.transaction.Transactional;

public interface CourseDao extends JpaRepository<Course, Integer> {

    public List<Course> findByCoursescoreAndCoursetype(int coursescore, String coursetype);

    public List<Course> findByCoursescoreOrCoursetype(int coursescore, String coursetype);

    public List<Course> findByCoursetimeBetween(int start, int end);

    public List<Course> findByCoursetimeLessThan(int coursetime);

    public List<Course> findByCoursenameContains(String coursename);

    @Query("select c from course c where c.coursescore>?1")
    public List<Course> selectCourses1(int coursescore);

    @Query("select c from course c where c.coursescore>?1 and c.coursetime>?2")
    public List<Course> selectCourses2(int coursescore, int coursetime);

    @Query(value = "select c from course c where c.coursescore>?1", nativeQuery = true)
    public List<Course> selectCourses3(int coursescore);

    @Query("select c from course c where c.coursescore>:coursescore")
    public List<Course> selectCourses4(@Param("coursescore") int coursescore);

    @Query("select c from course c where c.coursename like %?1%")
    public List<Course> selectCourses5(String coursename);

    @Transactional
    @Modifying
    @Query("update course set coursename = ?1, coursescore = ?2, coursetime = ?3, coursetype=?4 where courseid = ?5")
    public void updateCourse(String coursename, int coursescore, int coursetime, String coursetype, int courseid);
}
