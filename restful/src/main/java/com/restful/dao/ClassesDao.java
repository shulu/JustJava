package com.restful.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.entity.Classes;

public interface ClassesDao extends JpaRepository<Classes, Integer> {

}
