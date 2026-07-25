package com.practice.cats.gram.service;

import com.practice.cats.gram.exceptions.InvalidEmailException;
import com.practice.cats.gram.exceptions.UserAlreadyExistsException;
import com.practice.cats.gram.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Stream;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public Collection<User> findAll() {
        return users.values();
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }

    public User create(User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта пользователя не может быть пустой!");
        }

        if (users.containsKey(user.getEmail())) {
            throw new UserAlreadyExistsException("Пользователь с такой почтой уже существует!");
        }

        users.put(user.getEmail(), user);
        return user;
    }

    public User update( User user) {
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidEmailException("Почта пользователя не может быть пустой");
        }

        users.put(user.getEmail(), user);
        return user;
    }
}