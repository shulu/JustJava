/*
 * @Author: shulu
 * @Date: 2024-08-28 20:58:28
 * @LastEditors: shulu
 * @LastEditTime: 2024-08-28 21:30:08
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\dao\StudentJPARepository.java
 */
package com.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.restful.entity.Student;

public interface StudentJPARepository extends JpaRepository<Student, Integer>, JpaSpecificationExecutor {

}
