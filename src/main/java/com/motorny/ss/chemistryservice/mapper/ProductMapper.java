package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toProductDto(Product product);
    Product toProduct(ProductDto productDto);
}
