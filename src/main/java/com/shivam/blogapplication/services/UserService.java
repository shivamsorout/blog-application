package com.shivam.blogapplication.services;

import com.shivam.blogapplication.entities.User;
import com.shivam.blogapplication.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto createUser(User user);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
