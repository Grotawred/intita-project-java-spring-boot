package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.IService.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {
    @Autowired
    private  PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getByUserId(Long id) {
        return postRepository.findByUserID(id);
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }
}
