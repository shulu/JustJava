package com.restful.repository;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restful.entity.Book;

@Mapper
public interface BookBpMapper extends BaseMapper<Book> {

}
