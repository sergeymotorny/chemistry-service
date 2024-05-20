package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.CategoryDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.CategoryMapper;
import com.motorny.ss.chemistryservice.model.Category;
import com.motorny.ss.chemistryservice.repository.CategoryRepository;
import com.motorny.ss.chemistryservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(categoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategory(long id) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.orElse(null);
        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(saveCategory);
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));

        existingCategory.setName(categoryDto.getName());
        existingCategory.setDescription(categoryDto.getDescription());

        categoryRepository.save(existingCategory);

        return categoryMapper.toCategoryDto(existingCategory);
    }
}
