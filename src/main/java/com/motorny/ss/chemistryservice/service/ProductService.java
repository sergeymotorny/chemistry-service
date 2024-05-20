package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProduct(long id);
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(long id);
    ProductDto updateProduct(ProductDto productDto, long id);
}
