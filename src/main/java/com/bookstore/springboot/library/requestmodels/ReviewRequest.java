package com.bookstore.springboot.library.requestmodels;

import lombok.Data;
import org.apache.catalina.util.Introspection;

import java.util.Optional;

@Data
public class ReviewRequest {

    private double rating;

    private Long bookId;

    private Optional<String> reviewDescription;

    private Integer sentimentScore;
}
