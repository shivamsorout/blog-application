package com.shivam.blogapplication.services.impl;

import com.shivam.blogapplication.entities.Category;
import com.shivam.blogapplication.exceptions.ResourceNotFoundException;
import com.shivam.blogapplication.payloads.CategoryDto;
import com.shivam.blogapplication.repositories.CategoryRepo;
import com.shivam.blogapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Categor", "id", categoryId));
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }
    public void deleteCategory2(Integer categoryId) {
        categoryRepo.delete(categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "id", categoryId)));
    }

    @Override
    public CategoryDto getCategory(Integer categoryID) {
        Category category = categoryRepo.findById(categoryID).orElseThrow(()->new ResourceNotFoundException("Category", "id", categoryID));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(category -> modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    }
}
