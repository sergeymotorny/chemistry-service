package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAllBrands();
    BrandDto getBrand(long id);
    BrandDto createBrand(BrandDto brandDto);
    void deleteBrand(long id);
    BrandDto updateBrand(BrandDto brandDto, long id);
}
