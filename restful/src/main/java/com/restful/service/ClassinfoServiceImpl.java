package com.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.entity.Classinfo;
import com.restful.repository.ClassinfoMapper;

@Service
public class ClassinfoServiceImpl implements ClassinfoService {

    @Autowired
    private ClassinfoMapper classinfoMapper;

    @Override
    public Classinfo findClassinfoById(int classno) {
        return classinfoMapper.findClassinfoById(classno);
    }
}
