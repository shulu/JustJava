/*
 * @Author: shulu
 * @Date: 2024-08-28 20:58:28
 * @LastEditors: shulu
 * @LastEditTime: 2024-09-03 16:37:27
 * @Description: file content
 * @FilePath: \restful\src\main\java\com\restful\dao\StudentDao.java
 */
package com.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.restful.entity.Student;

@SuppressWarnings("rawtypes")
public interface StudentDao extends JpaRepository<Student, Integer>, JpaSpecificationExecutor {

}
