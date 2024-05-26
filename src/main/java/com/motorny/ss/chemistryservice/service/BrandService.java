package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.BrandDto;

import java.util.List;
import java.util.Map;

public interface BrandService {
    List<BrandDto> getAllBrands();
    BrandDto getBrand(long id);
    BrandDto createBrand(BrandDto brandDto);
    String deleteBrand(long id);
    BrandDto updateBrand(BrandDto brandDto, long id);
    List<Map<String, Object>> countBrandsByCountryInCity(String city);
}
