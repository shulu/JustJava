package com.restful.service;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.restful.entity.Book;
import com.restful.repository.BookbpMapper;

@Service
public class BookServiceImpl2 extends ServiceImpl<BookbpMapper, Book> implements IBookService {

}
