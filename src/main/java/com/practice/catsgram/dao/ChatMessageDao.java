package com.practice.catsgram.dao;

import com.practice.catsgram.model.ChatMessage;
import com.practice.catsgram.model.User;

import java.util.List;

public interface ChatMessageDao {
    List<ChatMessage> findChatMessagesForUsers(User userFrom, User userTo);
}
