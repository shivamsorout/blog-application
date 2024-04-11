package com.shivam.blogapplication.controllers;

import com.shivam.blogapplication.payloads.ApiResponse;
import com.shivam.blogapplication.payloads.PostDto;
import com.shivam.blogapplication.payloads.PostResponse;
import com.shivam.blogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;
    // create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDto post = postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
    }
    //get
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable("postId") Integer postId){
        PostDto postDto = postService.getPostById(postId);
        return ResponseEntity.ok(postDto);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> postDtos = postService.getAllPost();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/posts/pagination")
    public ResponseEntity<PostResponse> getAllPostForPagination(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5q", required = false) Integer pageSize){
        PostResponse postResponse = postService.getAllPostForPagination(pageNumber, pageSize);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> postDtos = postService.getPostsByCategory(categoryId);
        return ResponseEntity.ok(postDtos);
    }
    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable("postId") Integer postId){
        PostDto postDtoById = postService.updatePost(postDto,postId);
        return new ResponseEntity<>(postDtoById,HttpStatus.OK);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<PostDto> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity(new ApiResponse("Post has succesfully Deleted", true),HttpStatus.OK);
    }
}
