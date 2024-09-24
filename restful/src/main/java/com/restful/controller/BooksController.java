package com.restful.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.restful.entity.Books;
import com.restful.service.BooksService;

@Controller
public class BooksController {

    @Autowired
    private BooksService booksService;

    @ResponseBody
    @GetMapping("/setValue")
    public String setValue() {
        booksService.setValue("redis", "Spring Data Redis");
        return "保存键-值对成功";
    }

    @ResponseBody
    @GetMapping("/getValue")
    public String getValue() {
        ModelAndView mv = new ModelAndView();
        return booksService.getValue("redis");
    }

    @GetMapping("/saveBook")
    @ResponseBody
    public String saveBook() {
        Books books = new Books(1, "C语言程序设计", 50.0, "计算机", 100, "100.jpg", "", "zhangsan", 50);
        booksService.saveBook(books);
        return "保存一本书成功";
    }

    @GetMapping("/findBooks")
    public ModelAndView findBooksById() {
        ModelAndView mv = new ModelAndView();
        Books books = booksService.findBooksById(1);
        System.out.println(books);
        mv.addObject("book", books);
        mv.setViewName("book");
        return mv;
    }

    @ResponseBody
    @GetMapping("/saveBooks")
    public String saveBooks() {
        Books books1 = new Books(1, "C语言程序设计1", 50.0, "计算机", 100, "101.jpg", "", "zhangsan", 50);
        Books books2 = new Books(2, "C语言程序设计2", 50.0, "计算机", 100, "101.jpg", "", "zhangsan", 50);
        var books3 = new Books(3, "C语言程序设计3", 50.0, "计算机", 100, "101.jpg", "", "zhangsan", 50);
        List<Books> books = new ArrayList<>();
        books.add(books1);
        books.add(books2);
        books.add(books3);
        booksService.saveBooks("101", books);
        return "保存多本书成功";
    }

    @GetMapping("/findBooksById")
    public ModelAndView findBooksById(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        List<Books> books = booksService.findBooks("101");
        Books books1 = new Books();
        if (books != null && !books.isEmpty()) {
            books1 = books.get(id - 1);
        }
        mv.addObject("books1", books1);
        mv.setViewName("book");
        return mv;
    }

    @GetMapping("/findBooks2")
    public ModelAndView findBooks() {
        ModelAndView mv = new ModelAndView();
        List<Books> books = booksService.findBooks("101");
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }

    @GetMapping("/deleteBooks/{Id}")
    public ModelAndView deleteBooks(@PathVariable("id") int id) {
        ModelAndView mv = new ModelAndView();
        booksService.deleteBook(id);
        List<Books> books = booksService.findBooks("101");
        books.remove(id - 1);
        booksService.saveBooks("101", books);
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }

}
