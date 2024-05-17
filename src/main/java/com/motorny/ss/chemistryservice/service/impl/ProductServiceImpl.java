package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.ProductMapper;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.repository.ProductRepository;
import com.motorny.ss.chemistryservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(long id) {
        Optional<Product> byId = productRepository.findById(id);
        Product product = byId.orElse(null);
        return productMapper.toProductDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        Product savedProduct = productRepository.save(product);

        return productMapper.toProductDto(savedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        existingProduct.setBrandId(productDto.getBrandId());
        existingProduct.setCategoryId(productDto.getCategoryId());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setExpiryDate(productDto.getExpiryDate());

        productRepository.save(existingProduct);

        return productMapper.toProductDto(existingProduct);
    }
}
