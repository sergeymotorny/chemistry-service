package com.motorny.ss.chemistryservice.service.impl;

import com.motorny.ss.chemistryservice.dto.CategoryDto;
import com.motorny.ss.chemistryservice.exceptions.ResourceNotFoundException;
import com.motorny.ss.chemistryservice.mapper.CategoryMapper;
import com.motorny.ss.chemistryservice.model.Category;
import com.motorny.ss.chemistryservice.repository.CategoryRepository;
import com.motorny.ss.chemistryservice.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
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

        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Category not found with id " + id);
        }

        Category category = byId.get();

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.toCategory(categoryDto);
        Category saveCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(saveCategory);
    }

    @Override
    public String deleteCategory(long id) {
        Optional<Category> byId = categoryRepository.findById(id);

        if (byId.isPresent()) {
            categoryRepository.deleteById(id);
            return "Category with id: " + id + " was successfully remover";
        } else {
            log.error("Category not found with id {}", id);
            throw new ResourceNotFoundException("Category not found with id " + id);
        }
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
