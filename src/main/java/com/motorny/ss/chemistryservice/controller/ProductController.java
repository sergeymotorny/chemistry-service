package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.model.Product;
import com.motorny.ss.chemistryservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.updateProduct(product, id);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "Product with id: " + id + " was deleted";
    }

}
