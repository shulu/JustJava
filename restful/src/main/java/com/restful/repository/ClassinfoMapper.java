package com.restful.repository;

import org.apache.ibatis.annotations.Mapper;

import com.restful.entity.Classinfo;

@Mapper
public interface ClassinfoMapper {

    public Classinfo findClassinfoById(int classno);
}
