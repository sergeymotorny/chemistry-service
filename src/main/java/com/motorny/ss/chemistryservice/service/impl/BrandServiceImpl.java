package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.BrandDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.BrandMapper;
import com.motorny.ss.chemistryservice.model.Brand;
import com.motorny.ss.chemistryservice.repository.BrandRepository;
import com.motorny.ss.chemistryservice.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();

        return brands.stream()
                .map(brandMapper::toBrandDto)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto getBrand(long id) {
        Optional<Brand> byId = brandRepository.findById(id);
        Brand brand = byId.orElse(null);

        return brandMapper.toBrandDto(brand);
    }

    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = brandMapper.toBrand(brandDto);
        Brand saveBrand = brandRepository.save(brand);
        return brandMapper.toBrandDto(saveBrand);
    }

    @Override
    public void deleteBrand(long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public BrandDto updateBrand(BrandDto brandDto, long id) {
        Brand existingBrand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not found with id " + id));

        existingBrand.setName(brandDto.getName());
        existingBrand.setCountry(brandDto.getCountry());
        existingBrand.setYearFounded(brandDto.getYearFounded());

        brandRepository.save(existingBrand);

        return brandMapper.toBrandDto(existingBrand);
    }
}
