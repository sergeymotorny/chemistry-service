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
import com.motorny.ss.chemistryservice.repository.prod.PRepository;
import com.motorny.ss.chemistryservice.service.ProductService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final ProductMapper productMapper;
    private PRepository pRepository;

    private EntityManager entityManager;

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

        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }

        Product product = byId.get();

        return productMapper.toProductDto(product);
    }

    @Transactional
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
    public String deleteProduct(long id) {
        Optional<Product> byId = productRepository.findById(id);

        if (byId.isPresent()) {
            productRepository.deleteById(id);
            return "Product with id: " + id + " was successfully remover";
        } else {
            log.error("Product not found with id {}", id);
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
    }

    @Transactional
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

    @Transactional
    @Override
    public String updateExpiryDate(Long productId, LocalDate newExpiryDate) {
        Optional<Product> existingProduct = productRepository.findById(productId);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();

            product.setExpiryDate(newExpiryDate);

            productRepository.save(product);
            return "Product with id: " + productId + " was successfully updated";
        } else {
            throw new ResourceNotFoundException("Product not found with id " + productId);
        }
    }

    @Override
    public List<ProductDto> findProductsByPrice(Integer amount) {
        List<Product> productList = productRepository.findProductByPrice(amount);

        if (!productList.isEmpty()) {
            return productList.stream()
                    .map(productMapper::toProductDto)
                    .collect(Collectors.toList());
        } else {
            throw new ResourceNotFoundException("Product not found with price " + amount);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDto> findProductsByBrandId(Long id) {
        List<Product> productList = pRepository.findProductsByBrandId(id);

        return productList.stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getCountProductsByPriceAndBrandCategory() {
        List<Object[]> productList = productRepository.countProductsByPriceAndBrandCategory();
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] objects : productList) {
            Map<String, Object> item = new HashMap<>();
            item.put("name_brand", objects[0]);
            item.put("name_category", objects[1]);
            item.put("price", objects[2]);
            item.put("count", objects[3]);
            response.add(item);
        }

        return response;
    }


}
