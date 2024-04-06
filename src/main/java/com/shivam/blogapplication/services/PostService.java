package com.shivam.blogapplication.services;
import com.shivam.blogapplication.payloads.PostDto;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {
    //create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //delete
    void deletePost(Integer postId);
    //get all post
    List<PostDto> getAllPost();

    //get all post for pagination
    List<PostDto> getAllPostForPagination(Integer pageNumber, Integer pageSize);
    //get Single Post
    PostDto getPostById(Integer postId);
    //get all post by category
    List<PostDto> getPostsByCategory(Integer categoryId);
    //get all post by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts by keyword
    List<PostDto> searchPostBYKeyword(String keyword);

}
