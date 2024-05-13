package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProduct();
    ProductDto getProduct(long id);
    ProductDto createProduct(Product product);
    void deleteProduct(long id);
    ProductDto updateProduct(Product product, Long id);
}
