package com.shivam.blogapplication.services.impl;

import com.shivam.blogapplication.entities.Category;
import com.shivam.blogapplication.entities.Post;
import com.shivam.blogapplication.entities.User;
import com.shivam.blogapplication.exceptions.ResourceNotFoundException;
import com.shivam.blogapplication.payloads.PostDto;
import com.shivam.blogapplication.payloads.PostResponse;
import com.shivam.blogapplication.repositories.CategoryRepo;
import com.shivam.blogapplication.repositories.PostRepo;
import com.shivam.blogapplication.repositories.UserRepo;
import com.shivam.blogapplication.services.PostService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId", userId));
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", categoryId));
        Post post = postRepo.save(modelMapper.map(postDto, Post.class));
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post newPost = postRepo.save(post);
        return modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","postId",postId));
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setImageName(postDto.getImageName());
        Post post1 = postRepo.save(post);
        return modelMapper.map(post1, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        postRepo.deleteById(postId);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return  postDtos;
    }
    @Override
    public PostResponse getAllPostForPagination(Integer pageNumber, Integer pageSize){
        Pageable p = PageRequest.of(pageNumber, pageSize);
        Page<Post> postPage = postRepo.findAll(p);
        List<Post> posts = postPage.getContent();
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(postPage.getNumber());
        postResponse.setPageSize(postPage.getSize());
        postResponse.setTotalElement(postPage.getTotalElements());
        postResponse.setTotalPage(postPage.getTotalPages());
        postResponse.setLastPage(postPage.isLast());
        return  postResponse;
    }


    @Override
    public PostDto getPostById(Integer postId) {
       Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","Category",categoryId));
        List<Post> posts = postRepo.findByCategory(category);
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());;
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPostBYKeyword(String keyword) {
        return null;
    }
}
