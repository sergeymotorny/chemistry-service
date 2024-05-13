package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.exceptions.CustomEmptyDataException;
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

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(ProductDto::fromProduct)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.orElse(null);
        return ProductDto.fromProduct(product);
    }

    @Override
    public ProductDto createProduct(Product product) {
        return ProductDto.fromProduct(productRepository.save(product));
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto updateProduct(Product source, Long id) {
        Optional<Product> byId = productRepository.findById(id);

        if (byId.isPresent()) {
            Product prod = byId.get();
            prod.setBrandId(source.getBrandId());
            prod.setCategoryId(source.getCategoryId());
            prod.setPrice(source.getPrice());
            prod.setDescription(source.getDescription());
            prod.setExpiryDate(source.getExpiryDate());
            productRepository.save(prod);

            return ProductDto.fromProduct(prod);
        } else {
            throw new CustomEmptyDataException("unable to update product");
        }
    }

    private ProductDto mapToDto(Product product) {
        return new ProductDto(product.getId(), product.getBrandId(), product.getCategoryId(), product.getPrice(),
                product.getDescription(), product.getExpiryDate());
    }
}
