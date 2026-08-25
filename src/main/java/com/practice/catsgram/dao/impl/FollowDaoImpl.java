package com.practice.catsgram.dao.impl;

import com.practice.catsgram.dao.FollowDao;
import com.practice.catsgram.model.Post;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FollowDaoImpl implements FollowDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserDaoImpl userDao;

    @Override
    public List<Post> getFollowFeed(String userId, int max) {
        String sql = "select cp.id AS post_id, cp.description, cp.photo_url, cp.creation_date, cu.id AS user_id, cu.nickname, cu.username from cat_follow cf join cat_post cp on cp.author_id = cf.author_id join cat_user cu on cu.id = cp.author_id where cf.user_id = ? order by cp.creation_date desc limit ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User author = new User(
                    rs.getString("user_id"),
                    rs.getString("nickname"),
                    rs.getString("username")
            );
            return new Post(
                    rs.getInt("post_id"),
                    author,
                    rs.getString("description"),
                    rs.getString("photo_url"),
                    rs.getDate("creation_date").toLocalDate()
            );
        }, userId, max);
    }
}
