package com.motorny.ss.chemistryservice.dto;

import com.motorny.ss.chemistryservice.model.Brand;
import com.motorny.ss.chemistryservice.model.Category;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductDto {

    private long id;
    private Brand brandId;
    private Category categoryId;
    private BigDecimal price;
    private String description;
    private LocalDate expiryDate;
}
