package com.motorny.ss.chemistryservice.dto;

import com.motorny.ss.chemistryservice.model.Brand;
import com.motorny.ss.chemistryservice.model.Category;
import com.motorny.ss.chemistryservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private long id;
    private Brand brandId;
    private Category categoryId;
    private BigDecimal price;
    private String description;
    private LocalDate expiryDate;

    public Product toProduct() {
        Product product = new Product();
        product.setId(id);
        product.setBrandId(brandId);
        product.setCategoryId(categoryId);
        product.setPrice(price);
        product.setDescription(description);
        product.setExpiryDate(expiryDate);

        return product;
    }

    public ProductDto fromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setBrandId(product.getBrandId());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setExpiryDate(product.getExpiryDate());

        return productDto;
    }

}
