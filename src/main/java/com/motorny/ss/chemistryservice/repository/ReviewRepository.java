package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "SELECT r FROM Review r ORDER BY r.rating ASC")
    List<Review> findReviewByOrderByRating();
}
