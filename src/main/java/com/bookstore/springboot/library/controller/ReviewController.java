package com.bookstore.springboot.library.controller;

import com.bookstore.springboot.library.requestmodels.ReviewRequest;
import com.bookstore.springboot.library.service.ReviewService;
import com.bookstore.springboot.library.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("api/reviews")
@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/secure")
    public void postReview(@RequestBody ReviewRequest reviewRequest) throws Exception {
        String userEmail = "testuser@email.com";
        reviewService.postReview(userEmail, reviewRequest);
    }

    @GetMapping("/secure/user/book")
    public Boolean reviewBookByUser(@RequestParam Long bookId) throws Exception{
        String userEmail = "testuser@email.com";
        return reviewService.userReviewListed(userEmail, bookId);
    }
}
