package com.bookstore.springboot.library.service;

import com.bookstore.springboot.library.dao.BookRepository;
import com.bookstore.springboot.library.dao.ReviewRepository;
import com.bookstore.springboot.library.entity.Review;
import com.bookstore.springboot.library.requestmodels.ReviewRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {

    private BookRepository bookRepository;

    private ReviewRepository reviewRepository;

    public ReviewService(BookRepository bookRepository, ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
        if (validateReview != null) {
            throw new Exception("Review already created");
        }

        Review review = new Review();
        review.setBookId(review.getBookId());
        review.setRating(reviewRequest.getRating());
        review.setUserEmail(userEmail);
        if (reviewRequest.getReviewDescription().isPresent()) {
            review.setReviewDescription(reviewRequest.getReviewDescription().map(
                    Object::toString
            ).orElse(null));
        }
        review.setDate(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }
}
