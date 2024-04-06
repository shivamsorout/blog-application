package com.shivam.blogapplication.services;

import com.shivam.blogapplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get
    CategoryDto getCategory(Integer categoryID);
    //getAll
    List<CategoryDto> getAllCategory();
}
