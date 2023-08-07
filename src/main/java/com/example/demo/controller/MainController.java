package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final PostRepository postRepository;

    @GetMapping("/posts/page")
    Page<Post> loadCharactersPage(
            @PageableDefault
            @SortDefault(sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable){
        return postRepository.findAllPage(pageable);
    }
}
