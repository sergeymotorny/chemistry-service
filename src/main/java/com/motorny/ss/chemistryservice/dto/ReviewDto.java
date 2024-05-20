package com.motorny.ss.chemistryservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewDto {

    private Long id;
    private Long productId;
    private Long userId;
    private short rating;
    private String comment;
    private LocalDateTime createReview;
}
