package com.practice.catsgram.dao.impl;

import com.practice.catsgram.dao.UserDao;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<User> findUserById(String id) {
        String sql = "select * from cat_user where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, UserDaoImpl::userRowMapper, id));
    }

    public List<User> findAll() {
        return jdbcTemplate.query("select * from cat_user", UserDaoImpl::userRowMapper);
    }

    private static User userRowMapper(ResultSet rs, int rowNut) throws SQLException {
        return new User(rs.getString("id"),
                rs.getString("username"),
                rs.getString("nickname")
        );
    }
}