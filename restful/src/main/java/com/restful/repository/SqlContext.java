package com.restful.repository;

import org.apache.ibatis.jdbc.SQL;

import com.restful.entity.Book;

public class SqlContext {

    public String searchBookSql(Book book) {
        return new SQL() {
            {
                SELECT("*");
                FROM("book");
                if (book.getName() != null && !"".equals(book.getName())) {
                    WHERE("name like '%' #{name} '%'");
                }
                if (book.getCategory() != null && !"".equals(book.getCategory())) {
                    WHERE("category=#{category}");
                }
                if (book.getAuthor() != null && !"".equals(book.getAuthor())) {
                    WHERE("author=#{author}");
                }
            }
        }.toString();
    }
}
