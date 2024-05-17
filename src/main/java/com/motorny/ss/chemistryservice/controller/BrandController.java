package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.BrandDto;
import com.motorny.ss.chemistryservice.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/b")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/brand/{id}")
    public BrandDto getBrand(@PathVariable("id") Long id) {
        return brandService.getBrand(id);
    }

    @PostMapping("/brand")
    public BrandDto createBrand(@RequestBody BrandDto brandDto) {
        return brandService.createBrand(brandDto);
    }

    @DeleteMapping("/brand/{id}")
    public void deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteBrand(id);
    }

    @PutMapping("/brand/{id}")
    public BrandDto updateBrand(@RequestBody BrandDto brandDto, @PathVariable("id") Long id) {
       return brandService.updateBrand(brandDto, id);
    }
}
