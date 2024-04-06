package com.shivam.blogapplication.services.impl;

import com.shivam.blogapplication.entities.User;
import com.shivam.blogapplication.exceptions.ResourceNotFoundException;
import com.shivam.blogapplication.payloads.UserDto;
import com.shivam.blogapplication.repositories.UserRepo;
import com.shivam.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    //Java Bean is Validated with JSR 380 known as Bean Validation 2.0
    //JSR 380 is specification of Java API for bean validation. Properties of bean meet the specific criteria.
    //For validation different annotation is used like @NotNull, @Min, @Size etc.
    //Hibernate Validator is an implementation validation api
    //Some annotation : @NotNull, @Email, @Size,Min, @Max, @NotEmpty(For null and Empty)

    @Override
    public UserDto createUser(User user) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow((()-> new ResourceNotFoundException("User","id",userId)));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User user1 =  this.userRepo.save(user);
        UserDto userDto1 = this.userToUserDto(user1);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow((()-> new ResourceNotFoundException("User","id",userId)));
        UserDto userDto = this.userToUserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = this.userRepo.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for(User user:userList){
//            userDtos.add(this.userToUserDto(user));
//        }
        List<UserDto> userDtos = userList.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepo.deleteById(userId);
    }
    private User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
        return  user;
    }
    private UserDto userToUserDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
//        UserDto userDto = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return  userDto;
    }
}
