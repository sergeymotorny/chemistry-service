package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.BrandDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.BrandMapper;
import com.motorny.ss.chemistryservice.model.Brand;
import com.motorny.ss.chemistryservice.model.User;
import com.motorny.ss.chemistryservice.repository.BrandRepository;
import com.motorny.ss.chemistryservice.service.BrandService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

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

        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Brand not found with id " + id);
        }

        Brand brand = byId.get();

        return brandMapper.toBrandDto(brand);
    }

    @Transactional
    @Override
    public BrandDto createBrand(BrandDto brandDto) {
        Brand brand = brandMapper.toBrand(brandDto);
        Brand saveBrand = brandRepository.save(brand);

        return brandMapper.toBrandDto(saveBrand);
    }

    @Override
    public String deleteBrand(long id) {
        Optional<Brand> byId = brandRepository.findById(id);

        if (byId.isPresent()) {
            brandRepository.deleteById(id);
            return "Brand with id: " + id + " was successfully remover";
        } else {
            log.error("Brand not found with id {}", id);
            throw new ResourceNotFoundException("Brand not found with id " + id);
        }
    }

    @Transactional
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

    @Override
    public List<Map<String, Object>> countBrandsByCountryInCity(String city) {
        List<Object[]> results = brandRepository.countBrandsByCountry(city);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> item = new HashMap<>();
            item.put("country", result[0]);
            item.put("count", result[1]);
            response.add(item);
        }
        return response;
    }
}
