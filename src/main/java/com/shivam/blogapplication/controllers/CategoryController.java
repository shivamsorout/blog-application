package com.shivam.blogapplication.controllers;

import com.google.protobuf.Api;
import com.shivam.blogapplication.entities.Category;
import com.shivam.blogapplication.payloads.ApiResponse;
import com.shivam.blogapplication.payloads.CategoryDto;
import com.shivam.blogapplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catgories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createUser(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
        CategoryDto updadteCategory = categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<CategoryDto>(updadteCategory, HttpStatus.OK);
    }
    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category has been deleted succesfully !!", false),HttpStatus.OK);
    }
    @GetMapping("/{catId}")
    public  ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto1 =  categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
}
