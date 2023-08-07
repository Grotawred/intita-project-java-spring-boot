package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select c from Post c")
    Page<Post> findAllPage(Pageable pageable);

}
