package com.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
