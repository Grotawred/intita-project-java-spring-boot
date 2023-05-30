package com.example.demo.service.IService;

import com.example.demo.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> getAllPosts();

    List<Post> getByUserId(Long id);

    void savePost(Post post);

}
