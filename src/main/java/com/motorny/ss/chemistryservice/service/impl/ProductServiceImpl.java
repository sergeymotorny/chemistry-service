package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.repository.ProductRepository;
import com.motorny.ss.chemistryservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(long id) {
        return null;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    private ProductDto mapToDto(Product product) {
        return new ProductDto(product.getId(), product.getBrandId(), product.getCategoryId(), product.getPrice(),
                product.getDescription(), product.getExpiryDate());
    }
}
