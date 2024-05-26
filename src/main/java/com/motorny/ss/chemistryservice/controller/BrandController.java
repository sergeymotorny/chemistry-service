package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.BrandDto;
import com.motorny.ss.chemistryservice.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/b")
public class BrandController {

    private final BrandService brandService;

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
    public ResponseEntity<String> deleteBrand(@PathVariable("id") Long id) {
        return new ResponseEntity<>(brandService.deleteBrand(id), HttpStatus.OK);
    }

    @PutMapping("/brand/{id}")
    public BrandDto updateBrand(@RequestBody BrandDto brandDto, @PathVariable("id") Long id) {
       return brandService.updateBrand(brandDto, id);
    }

    @GetMapping("/brand/count/country")
    public List<Map<String, Object>> getBrandsCountByCountry(@RequestParam String country) {
        return brandService.countBrandsByCountryInCity(country);
    }
}
