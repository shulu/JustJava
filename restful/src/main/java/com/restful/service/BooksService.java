package com.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.dao.BooksDao;
import com.restful.entity.Books;

@Service
public class BooksService {

    @Autowired
    private BooksDao booksDao;

    public String getValue(String key) {
        return booksDao.getValue(key);
    }

    public void setValue(String key, String value) {
        booksDao.setValue(key, value);
    }

    public List<Books> findBooks(String id) {
        return booksDao.findBooks(id);
    }

    public void saveBooks(Object key, List<Books> books) {
        booksDao.saveBooks(key, books);
    }

    public Books findBooksById(int id) {
        return (Books) booksDao.findBookById(id);
    }

    public void saveBook(Books books) {
        booksDao.saveBook(books);
    }

    public void deleteBook(int id) {
        booksDao.deleteBook(id);
    }
}
