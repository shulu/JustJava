package com.restful.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.restful.entity.Book;
import com.restful.entity.Books;

@Repository
public class BooksDao {

    @Autowired
    private RedisTemplate redisTemplate;
    private StringRedisTemplate stringRedisTemplate;

    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void saveBooks(Object key, List<Books> books) {
        redisTemplate.opsForValue().set(key, books);
    }

    public Book findBookById(int id) {
        return (Book) redisTemplate.opsForValue().get(String.valueOf(id));
    }

    public void saveBook(Book book) {
        redisTemplate.opsForValue().set(String.valueOf(book.getId()), book);
    }

    public void deleteBook(int id) {
        redisTemplate.delete(String.valueOf(id));
    }
}
