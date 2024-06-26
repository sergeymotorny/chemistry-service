package com.motorny.ss.chemistryservice.controller;

import com.motorny.ss.chemistryservice.dto.CategoryDto;
import com.motorny.ss.chemistryservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/c")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public CategoryDto getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/category")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.createCategory(categoryDto);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("id") Long id) {
        return categoryService.updateCategory(categoryDto, id);
    }
}
