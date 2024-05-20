package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    @Query(value = "FROM Review review JOIN FETCH review.product JOIN FETCH review.user")
//    List<Review> findAll();

//    @EntityGraph(attributePaths = { "product", "user" })
//    List<Review> findAll();
}
