package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dao.ClassesDao;
import com.restful.entity.Classes;

@Service
public class ClassesService {

    @Autowired
    private ClassesDao classesDao;

    public List<Classes> findAllClasses() {
        return classesDao.findAll();
    }
}
