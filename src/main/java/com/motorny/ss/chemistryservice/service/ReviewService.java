package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getAllReviews();
    ReviewDto getReview(long id);
    ReviewDto createReview(ReviewDto reviewDto);
    String deleteReview(long id);
    ReviewDto updateReview(ReviewDto reviewDto, long id);
}
