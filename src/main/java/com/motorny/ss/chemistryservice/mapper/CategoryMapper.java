package com.motorny.ss.chemistryservice.mapper;

import com.motorny.ss.chemistryservice.dto.CategoryDto;
import com.motorny.ss.chemistryservice.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toCategoryDto(Category category);
    Category toCategory(CategoryDto categoryDto);
}
