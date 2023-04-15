package com.bookstore.springboot.library.controller;

import com.bookstore.springboot.library.service.ReviewService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RequestMapping("api/reviews")
@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

//    public void postReview(@RequestHeader(value = "Authorization") String token,
//                           @RequestBody ReviewRequest reviewRequest) throws Exception {
////        String userEmail = ExtractJWT.
//    }
}
