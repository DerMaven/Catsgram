package com.practice.cats.gram.controller;

import com.practice.cats.gram.exceptions.PostNotFoundException;
import com.practice.cats.gram.model.Post;
import com.practice.cats.gram.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:5174")
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> findAll(@RequestParam(defaultValue = "10", required = false) Integer size,
                              @RequestParam(defaultValue = "desc", required = false) String sort,
                              @RequestParam(defaultValue = "0", required = false) Integer page) {

        if (!(sort.equals("asc") || sort.equals("desc"))) {
            throw new IllegalArgumentException("Неверный тип сортировки");
        }
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Неверные параметры пагинации");
        }

        Integer from = page * size;
        return postService.findAll(size, from, sort);
    }

    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable Long postId) {
        return postService.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Пост с ID: " + postId + " не найден"));
    }

    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }
}