package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.ProductMapper;
import com.motorny.ss.chemistryservice.model.Brand;
import com.motorny.ss.chemistryservice.model.Category;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.model.Review;
import com.motorny.ss.chemistryservice.repository.BrandRepository;
import com.motorny.ss.chemistryservice.repository.CategoryRepository;
import com.motorny.ss.chemistryservice.repository.ProductRepository;
import com.motorny.ss.chemistryservice.repository.ReviewRepository;
import com.motorny.ss.chemistryservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final ProductMapper productMapper;

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

        Brand existingBrand = brandRepository.findById(productDto.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + productDto.getBrandId()));

        Category existingCategory = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + productDto.getCategoryId()));

        product.setBrand(existingBrand);
        product.setCategory(existingCategory);

        Product savedProduct = productRepository.save(product);

        return productMapper.toProductDto(savedProduct);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, long id) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        Brand existingBrand = brandRepository.findById(productDto.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + productDto.getBrandId()));

        Category existingCategory = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + productDto.getCategoryId()));

        Set<Review> reviews = productDto.getReviewIds().stream()
                .map(reviewId -> reviewRepository.findById(reviewId)
                        .orElseThrow(() -> new ResourceNotFoundException("Review not found with id " + reviewId)))
                .collect(Collectors.toSet());

        existingProduct.setBrand(existingBrand);
        existingProduct.setCategory(existingCategory);
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setExpiryDate(productDto.getExpiryDate());
        existingProduct.setReviews(reviews);

        productRepository.save(existingProduct);

        return productMapper.toProductDto(existingProduct);
    }
}
