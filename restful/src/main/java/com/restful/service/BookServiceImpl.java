package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.restful.entity.Book;
import com.restful.repository.BookMapper;
import com.restful.repository.BookbpMapper;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookbpMapper bookbpMapper;

    @Override
    public List<Book> findAllBooks() {
        // return bookMapper.findAllBooks();
        return bookbpMapper.selectList(null);
    }

    @Override
    public Book findBookById(int id) {
        // return bookMapper.findBookById(id);
        return bookbpMapper.selectById(id);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        // bookMapper.addBook(book);
        bookbpMapper.insert(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        // bookMapper.updateBook(book);
        bookbpMapper.updateById(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        // bookMapper.deleteBook(id);
        bookbpMapper.deleteById(id);
    }

    @Override
    public List<Book> searchBooks(Book book) {
        // myBatis 用法
        // return bookMapper.searchBooks(book);
        // mybatisplus 用法
        // queryWrapper
        String name = book.getName();
        // QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        // queryWrapper.like(!"".equals(name) && name != null, "name", name);
        // queryWrapper.eq(!"".equals(book.getCategory()) && book.getCategory() != null,
        // "category", book.getCategory());
        // queryWrapper.eq(!"".equals(book.getAuthor()) && book.getAuthor() != null,
        // "author", book.getAuthor());
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!"".equals(name) && name != null,
                Book::getName, name);
        queryWrapper.eq(!"".equals(book.getCategory()) && book.getCategory() != null,
                Book::getCategory, book.getCategory());
        queryWrapper.eq(!"".equals(book.getAuthor()) && book.getAuthor() != null,
                Book::getAuthor, book.getAuthor());
        return bookbpMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void deleteBooks(int[] id) {
        bookMapper.deleteBooks(id);
    }

    @Override
    public IPage<Book> getPage(int pageNum, int size) {
        IPage<Book> bookPage = new Page<>(pageNum, size);
        bookPage = bookbpMapper.selectPage(bookPage, null);
        return bookPage;
    }
}
