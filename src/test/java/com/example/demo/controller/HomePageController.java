package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.HomePageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class HomePageController {
    @InjectMocks
    private HomePageController mainController;

    @Mock
    private HomePageService mainService;

    private MockMvc mockMvc;


    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    public void testGetAllPosts() throws Exception{
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Title 1", "Content 1"));
        posts.add(new Post(2L, "Title 2", "Content 2"));

        Page<Post> page = new PageImpl<>(posts);

        given(mainService.getAllPosts(any(Pageable.class))).willReturn(page);
//        when(mainService.getAllPosts(any(Pageable.class))).thenReturn(page);

        mockMvc.perform(get("/home/posts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.content[0].header", is("Title 1")))
                .andExpect(jsonPath("$.content[1].header", is("Title 2")));
    }
}
