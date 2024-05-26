package com.motorny.ss.chemistryservice.repository.prod;

import com.motorny.ss.chemistryservice.config.Data;
import com.motorny.ss.chemistryservice.mapper.ProductMapper;
import com.motorny.ss.chemistryservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PRepository {

    private final ProductMapper productMapper;

    public PRepository(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> findProductsByBrandId(Long brandId) {
        return Data.getProductDtos().stream()
                .filter(dto -> dto.getBrandId().equals(brandId))
                .map(productMapper::toProduct)
                .collect(Collectors.toList());
    }
}
