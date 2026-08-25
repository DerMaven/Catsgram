package com.practice.catsgram.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Follow {
    private String userId;
    private String authorId;

    public Follow(String userId, String authorId) {
        this.userId = userId;
        this.authorId = authorId;
    }
}
