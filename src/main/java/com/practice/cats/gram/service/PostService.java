package com.practice.cats.gram.service;

import com.practice.cats.gram.exceptions.PostNotFoundException;
import com.practice.cats.gram.exceptions.UserNotFoundException;
import com.practice.cats.gram.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserService userService;
    private final List<Post> posts = new ArrayList<>();

    public Optional<Post> findById(Long postId) {
        return posts.stream()
                .filter(post -> Objects.equals(post.getId(), postId))
                .findFirst();
    }

    public List<Post> findAll(Integer size, Integer from, String sort) {
        return getSortedStream(posts.stream(), sort)
                .skip(Math.max(0, from != null ? from : 0))
                .limit(Math.max(0, size != null ? size : Integer.MAX_VALUE))
                .collect(Collectors.toList());
    }

    public List<Post> findAllByUserEmail(String email, Integer size, String sort) {
        return getSortedStream(
                posts.stream().filter(post -> Objects.equals(email, post.getAuthor())),
                sort
        )
                .limit(Math.max(0, size != null ? size : Integer.MAX_VALUE))
                .collect(Collectors.toList());
    }

    public Post create(Post post) {
        String email = post.getAuthor();
        if (userService.findUserByEmail(email) == null) {
            throw new UserNotFoundException(String.format("Пользователь с email %s не найден", email));
        }
        posts.add(post);
        return post;
    }

    private Stream<Post> getSortedStream(Stream<Post> stream, String sort) {
        Comparator<Post> comparator = Comparator.comparing(Post::getCreationDate);
        if ("desc".equalsIgnoreCase(sort)) {
            comparator = comparator.reversed();
        }
        return stream.sorted(comparator);
    }
}