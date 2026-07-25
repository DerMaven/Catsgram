package com.practice.cats.gram.controller;

import com.practice.cats.gram.model.Post;
import com.practice.cats.gram.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5174")
public class PostFeedController {

    private final PostService postService;

    @PostMapping("/feed/friends")
    public List<Post> getFriendsFeed(@RequestBody FriendsParams friendsParams) {

        if (friendsParams == null || friendsParams.getFriends() == null || friendsParams.getFriends().isEmpty()) {
            throw new IllegalArgumentException("Неверно заполнены параметры");
        }

        List<Post> result = new ArrayList<>();
        for (String friend : friendsParams.getFriends()) {
            result.addAll(postService.findAllByUserEmail(
                    friend,
                    friendsParams.getSize() != null ? friendsParams.getSize() : 10,
                    friendsParams.getSort() != null ? friendsParams.getSort() : "desc"
            ));
        }
        return result;
    }

    @Setter
    @Getter
    public static class FriendsParams {
        private String sort;
        private Integer size;
        private List<String> friends;
    }
}