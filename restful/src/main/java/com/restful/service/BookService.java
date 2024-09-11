package com.restful.service;

import java.util.List;

import com.restful.entity.Book;

public interface BookService {
    public List<Book> findAllBooks();

    public Book findBookById(int id);

    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(int id);

    public List<Book> searchBooks(Book book);

    public void deleteBooks(int[] id);
}
