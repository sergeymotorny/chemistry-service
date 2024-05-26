package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.ReviewDto;
import com.motorny.ss.chemistryservice.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "user.id", target = "userId")
    ReviewDto toReviewDto(Review review);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    Review toReview(ReviewDto reviewDto);
}
