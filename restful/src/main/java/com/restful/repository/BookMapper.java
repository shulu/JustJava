package com.restful.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.restful.entity.Book;

@Mapper
public interface BookMapper {

    // @Select("select * from book")
    public List<Book> findAllBooks();

    // @Select("select * from book where id = #{id}")
    public Book findBookById(int id);

    // @Insert("insert into book values(null, #{name}, #{price}, #{category},
    // #{pnum}, #{imgurl}, #{description}, #{author}, #{sales})")
    public void addBook(Book book);

    // @Update("update book set name=#{name},price=#{price},category=#{category},"
    // + "pnum=#{pnum}, imgurl=#{imgurl}, description=#{description},"
    // + "author=#{author}, sales=#{sales} where id = #{id}")
    public void updateBook(Book book);

    // @Delete("delete from book where id = #{id}")
    public void deleteBook(int id);

    // @SelectProvider(method = "searchBookSql", type = SqlContext.class)
    public List<Book> searchBooks(Book book);

    public void deleteBooks(int[] ids);
}
