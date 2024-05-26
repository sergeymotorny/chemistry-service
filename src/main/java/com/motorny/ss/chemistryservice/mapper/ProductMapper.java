package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "brand.id", target = "brandId")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(target = "reviewIds", expression = "java(mapReviews(product.getReviews()))")
    ProductDto toProductDto(Product product);

    @Mapping(source = "brandId", target = "brand.id")
    @Mapping(source = "categoryId", target = "category.id")
    Product toProduct(ProductDto productDto);


    default Set<Long> mapReviews(Set<Review> reviews) {
        return reviews.stream()
               .map(Review::getId)
               .collect(Collectors.toSet());
    }
}
