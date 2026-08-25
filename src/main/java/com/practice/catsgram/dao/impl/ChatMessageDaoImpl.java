package com.practice.catsgram.dao.impl;

import com.practice.catsgram.dao.ChatMessageDao;
import com.practice.catsgram.model.ChatMessage;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChatMessageDaoImpl implements ChatMessageDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<ChatMessage> findChatMessagesForUsers(User userFrom, User userTo) {
        String sql = "select * from chat_message where user_from in (?, ?) and user_to in (?, ?)";
        return jdbcTemplate.query(sql,
                (rs, rowNum) -> new ChatMessage(rs.getInt("id"), userTo, userFrom, rs.getString("message"), rs.getDate("send_date")),
                userFrom.getId(), userTo.getId(), userTo.getId(), userFrom.getId());
    }
}
