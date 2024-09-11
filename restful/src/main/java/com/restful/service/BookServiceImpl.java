package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.entity.Book;
import com.restful.repository.BookMapper;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

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
        return bookMapper.searchBooks(book);
    }

    @Override
    @Transactional
    public void deleteBooks(int[] id) {
        bookMapper.deleteBooks(id);
    }
}
