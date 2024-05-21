package com.motorny.ss.chemistryservice.repository;

import com.motorny.ss.chemistryservice.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
