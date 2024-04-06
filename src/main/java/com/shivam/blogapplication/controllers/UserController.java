package com.shivam.blogapplication.controllers;

import com.shivam.blogapplication.payloads.ApiResponse;
import com.shivam.blogapplication.payloads.UserDto;
import com.shivam.blogapplication.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserService userService;

    //POST - Create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = userService.createUser(userDto);
        return  new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }
    //PUT - Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updateUser = this.userService.updateUser(userDto,userId);
        return  ResponseEntity.ok(updateUser);
    }
    //DELETE - Delete User
    @DeleteMapping("/{userId}")
//    public ResponseEntity<UserDto> deleteUser(@RequestBody UserDto userDto, @PathVariable(userId) Integer userId){
//        this.userService.deleteUser(userId);
//        return new ResponseEntity(Map.of("message","User has been deleted sucessfully"), HttpStatus.OK);
//    }
    public  ResponseEntity<ApiResponse> deleteUser(@Valid @PathVariable("userId") Integer userId){
        userService.deleteUser(userId);
        return  new ResponseEntity(new ApiResponse("User Has Been deleted successfully", true),HttpStatus.OK);
    }
    //GET - get users
    @GetMapping("/{userId}")
    public  ResponseEntity<UserDto> getUser(@Valid @PathVariable("userId") Integer userId){
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }
    //GET - get all users
    @GetMapping("/")
    public  ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
