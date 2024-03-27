package com.luv2code.springbootlibrary.service;

import com.luv2code.springbootlibrary.dao.ReviewRepository;
import com.luv2code.springbootlibrary.entity.Review;
import com.luv2code.springbootlibrary.requestmodels.ReviewRequest;
import com.luv2code.springbootlibrary.utils.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class ReviewService {

    private static final MyLogger logger = MyLogger.getInstance();

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void postReview(String userEmail, ReviewRequest reviewRequest) throws Exception {
        try {
            Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, reviewRequest.getBookId());
            if (validateReview != null) {
                throw new Exception("Review already created");
            }

            Review review = new Review();
            review.setBookId(reviewRequest.getBookId());
            review.setRating(reviewRequest.getRating());
            review.setUserEmail(userEmail);
            review.setReviewDescription(reviewRequest.getReviewDescription().orElse(null));
            review.setDate(Date.valueOf(LocalDate.now()));
            reviewRepository.save(review);
            logger.log("Review posted by user: " + userEmail);
        } catch (Exception e) {
            logger.log("Error occurred while posting review", e);
        }
    }

    public Boolean userReviewListed(String userEmail, Long bookId) {
        try {
            Review validateReview = reviewRepository.findByUserEmailAndBookId(userEmail, bookId);
            return validateReview != null;
        } catch (Exception e) {
            logger.log("Error occurred while checking if user review exists", e);
            return false;
        }
    }

}









