package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.restful.entity.Book;
import com.restful.repository.BookBpMapper;
import com.restful.repository.BookMapper;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookBpMapper bookBpMapper;

    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }

    @Override
    public Book findBookById(int id) {
        return bookMapper.findBookById(id);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    @Override
    public List<Book> searchBooks(Book book) {
        // myBatis 用法
        // return bookMapper.searchBooks(book);
        // mybatisplus 用法
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(book.getName() != "" && book.getName() != null, Book::getName, Book.getName());
        queryWrapper.eq(book.getCategory() != "" && book.getCategory() != null, Book::getCategory, book.getCategory());
        queryWrapper.eq(book.getAuthor() != "" && book.getAuthor() != null, Book::getAuthor, book.getAuthor());
        return bookBpMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void deleteBooks(int[] id) {
        bookMapper.deleteBooks(id);
    }

    public IPage<Book> getPage(int pageNum, int size) {
        IPage<Book> bookPage = new Page<>(pageNum, size);
        bookPage = bookBpMapper.selectPage(bookPage, null);
        return bookPage;
    }
}
