package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.BrandDto;
import com.motorny.ss.chemistryservice.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toBrandDto(Brand brand);
    Brand toBrand(BrandDto brandDto);
}
