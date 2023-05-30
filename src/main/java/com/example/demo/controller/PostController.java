package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.IService.IPostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private IPostService postService;

    @Operation(summary = "Get all posts")
    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @Operation(summary = "Get all post from certain user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Posts has been found"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Posts not found"
                    )
            })
    @GetMapping("/posts/{id}")
    public List<Post> getByUserId(@PathVariable(name = "id") Long id) {
        return postService.getByUserId(id);
    }

    @Operation(summary = "Save post")
    @PostMapping("/posts")
    public List<Post> savePost(Post post) {
        postService.savePost(post);
        return postService.getAllPosts();
    }

}
