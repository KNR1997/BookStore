package com.bookstore.springboot.library.dto;

import com.bookstore.springboot.library.entity.Book;
import lombok.Data;

@Data
public class BookDTO {

    private String title;

    private String author;

    private String description;

    private int copies;

    private int copiesAvailable;

    private String category;

    public BookDTO() {

    };
    public BookDTO(Book book){
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.description = book.getDescription();
        this.copies = book.getCopies();
        this.copiesAvailable = book.getCopiesAvailable();
        this.category = book.getCategory();
    }

}
