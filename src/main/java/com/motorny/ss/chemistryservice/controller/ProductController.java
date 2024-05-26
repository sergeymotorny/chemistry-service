package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/p")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Long id) {
        return productService.updateProduct(productDto, id);
    }

    @GetMapping("/products/price")
    public List<ProductDto> getProductsByPrice(@RequestParam Integer amount) {
        return productService.findProductsByPrice(amount);
    }

    @GetMapping("/product/brand/id")
    public List<ProductDto> getProductsByBrandId(@RequestParam Long idBrand) {
        return productService.findProductsByBrandId(idBrand);
    }

    @GetMapping("/products/price/count")
    public List<Map<String, Object>> getCountProductsByPrice() {
        return productService.getCountProductsByPriceAndBrandCategory();
    }

    @PutMapping("/product/{id}/expiry-date")
    public ResponseEntity<String> updateExpiryDate(@PathVariable("id") Long id,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate newExpiryDate ) {
        return new ResponseEntity<>(productService.updateExpiryDate(id, newExpiryDate), HttpStatus.OK);
    }

}
