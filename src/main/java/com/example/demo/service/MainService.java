package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

    private final PostRepository postRepository;

    public Page<Post> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

}
