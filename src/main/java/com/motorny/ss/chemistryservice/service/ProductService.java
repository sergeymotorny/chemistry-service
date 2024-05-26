package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.ProductDto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProduct(long id);
    ProductDto createProduct(ProductDto productDto);
    String deleteProduct(long id);
    ProductDto updateProduct(ProductDto productDto, long id);
    List<ProductDto> findProductsByPrice(Integer amount);
    List<ProductDto> findProductsByBrandId(Long id);
    List<Map<String, Object>> getCountProductsByPriceAndBrandCategory();
    String updateExpiryDate(Long id, LocalDate newExpiryDate);
}
