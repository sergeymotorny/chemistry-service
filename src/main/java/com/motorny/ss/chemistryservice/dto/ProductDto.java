package com.motorny.ss.chemistryservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class ProductDto {

    private Long id;
    private Long brandId;
    private Long categoryId;
    private BigDecimal price;
    private String description;
    private LocalDate expiryDate;
    private Set<Long> reviewIds;

    public ProductDto(Long id, Long brandId, Long categoryId, BigDecimal price, String description, LocalDate expiryDate) {
        this.id = id;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.price = price;
        this.description = description;
        this.expiryDate = expiryDate;
    }

    public ProductDto() { }
}
