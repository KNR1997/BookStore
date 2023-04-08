package com.bookstore.springboot.library.dao;

import com.bookstore.springboot.library.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {


}
