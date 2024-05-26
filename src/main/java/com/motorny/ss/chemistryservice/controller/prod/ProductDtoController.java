package com.motorny.ss.chemistryservice.controller.prod;

import com.motorny.ss.chemistryservice.dto.ProductDto;
import com.motorny.ss.chemistryservice.mapper.ProductMapper;
import com.motorny.ss.chemistryservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/p")
public class ProductDtoController {

    private ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/product/brand/{id}")
    public List<ProductDto> getProductsByBrandId(@PathVariable("id") Long id) {
        return productService.findProductsByBrandId(id);
    }
}
