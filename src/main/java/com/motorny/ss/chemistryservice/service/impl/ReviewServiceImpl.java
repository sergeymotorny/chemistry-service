package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.ReviewDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.ReviewMapper;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.model.Review;
import com.motorny.ss.chemistryservice.model.User;
import com.motorny.ss.chemistryservice.repository.ProductRepository;
import com.motorny.ss.chemistryservice.repository.ReviewRepository;
import com.motorny.ss.chemistryservice.repository.UserRepository;
import com.motorny.ss.chemistryservice.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviewList = reviewRepository.findAll();

        return reviewList.stream()
                .map(reviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReview(long id) {
        Optional<Review> byId = reviewRepository.findById(id);
        Review review = byId.orElse(null);

        return reviewMapper.toReviewDto(review);
    }

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = reviewMapper.toReview(reviewDto);

        Product existingProduct = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + reviewDto.getProductId()));

        User existingUser = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + reviewDto.getUserId()));

        review.setProduct(existingProduct);
        review.setUser(existingUser);

        Review saveReview = reviewRepository.save(review);

        return reviewMapper.toReviewDto(saveReview);
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto, long id) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + id));

        Product existingProduct = productRepository.findById(reviewDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + reviewDto.getProductId()));

        User existingUser = userRepository.findById(reviewDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + reviewDto.getUserId()));

        existingReview.setProduct(existingProduct);
        existingReview.setUser(existingUser);
        existingReview.setRating(reviewDto.getRating());
        existingReview.setComment(reviewDto.getComment());
        existingReview.setCreateReview(reviewDto.getCreateReview());

        reviewRepository.save(existingReview);

        return reviewMapper.toReviewDto(existingReview);
    }
}
