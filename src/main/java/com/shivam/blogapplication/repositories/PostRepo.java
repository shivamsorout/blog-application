package com.shivam.blogapplication.repositories;

import com.shivam.blogapplication.entities.Category;
import com.shivam.blogapplication.entities.Post;
import com.shivam.blogapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);
}
