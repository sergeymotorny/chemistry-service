package com.motorny.ss.chemistryservice.service;

import com.motorny.ss.chemistryservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategory(long id);
    CategoryDto createCategory(CategoryDto categoryDto);
    String deleteCategory(long id);
    CategoryDto updateCategory(CategoryDto categoryDto, long id);
}
