package com.bookstore.springboot.library.controller;

import com.bookstore.springboot.library.dto.BookDTO;
import com.bookstore.springboot.library.dto.BookTitleAuthorDTO;
import com.bookstore.springboot.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

//    @GetMapping("/getAllBook")
//    public List<BookDTO> getAllBooks() {
//        return bookService.getAllBooks();
//    }

//    @GetMapping("/book/{id}")
//    public List<BookTitleAuthorDTO> getBook(@PathVariable String id) {
//        return bookService.getBook();
//    }

    @PostMapping("/save-Book")
    public void saveBook() {

    }
}
