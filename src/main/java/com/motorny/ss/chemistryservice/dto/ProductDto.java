package com.motorny.ss.chemistryservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
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
}
