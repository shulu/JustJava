package com.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.restful.entity.Book;
import com.restful.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ModelAndView findAllBooks() {
        List<Book> books = bookService.findAllBooks();
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("booklist");
        return mv;
    }

    @GetMapping("/book/{id}")
    public ModelAndView findStudenById(@PathVariable("id") int id) {
        Book book = bookService.findBookById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book", book);
        mv.setViewName("bookdetail");
        return mv;
    }

    @PostMapping("/addBook")
    public ModelAndView addBook(Book book) {
        // TODO: process POST request
        bookService.addBook(book);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/books");
        return mv;
    }

    @GetMapping("/addBook")
    public String addBook() {

        return "addbook";
    }

    @GetMapping("/deleteBook/{id}")
    public ModelAndView deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/books");
        return mv;
    }

    @GetMapping("/toupdatebook/{id}")
    public ModelAndView toUpdateBook(@PathVariable("id") int id) {
        Book book = bookService.findBookById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book", book);
        mv.setViewName("updateBook");
        return mv;
    }

    @PostMapping("/updateBook")
    public ModelAndView UpdateBook(Book book) {
        // TODO: process POST request
        bookService.updateBook(book);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/books");
        return mv;
    }

    @GetMapping("/searchBooks")
    public ModelAndView searchBooks(Book book) {
        List<Book> books = bookService.searchBooks(book);
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("booklist");
        return mv;
    }

    @GetMapping("/booksPage")
    public ModelAndView booksPage(@RequestParam(value = "start", defaultValue = "1") int start,
            @RequestParam(value = "size", defaultValue = "3") int size) {
        PageHelper.startPage(start, size, "id asc");
        List<Book> books = bookService.findAllBooks();
        PageInfo<Book> page = new PageInfo<>(books);
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page);
        mv.setViewName("bookslistPage");
        return mv;
    }

}
