package com.practice.catsgram.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class ChatMessage {
    private Integer id;
    private User userTo;
    private User userFrom;
    private Date sendDate;
    private String message;
    private boolean userRead;

    public ChatMessage(Integer id, User userTo, User userFrom, String message, Date sendDate) {
        this.id = id;
        this.userTo = userTo;
        this.userFrom = userFrom;
        this.sendDate = sendDate;
        this.message = message;
    }
}
