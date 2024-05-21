package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.ReviewDto;
import com.motorny.ss.chemistryservice.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/r")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public List<ReviewDto> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/review/{id}")
    public ReviewDto getReview(@PathVariable("id") Long id) {
        return reviewService.getReview(id);
    }

    @PostMapping("/review")
    public ReviewDto createReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.createReview(reviewDto);
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reviewService.deleteReview(id), HttpStatus.OK);
    }

    @PutMapping("/review/{id}")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto, @PathVariable("id") Long id) {
        return reviewService.updateReview(reviewDto, id);
    }
}
