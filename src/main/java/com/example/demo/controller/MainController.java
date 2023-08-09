package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    private final MainService mainService;

    @GetMapping
    public ResponseEntity<Page<Post>> getAllPosts(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = mainService.getAllPosts(pageable);
        return ResponseEntity.ok(posts);
    }
}
