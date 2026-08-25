package com.practice.catsgram.service;

import com.practice.catsgram.dao.UserDao;
import com.practice.catsgram.exceptions.InvalidEmailException;
import com.practice.catsgram.exceptions.UserAlreadyExistsException;
import com.practice.catsgram.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final Map<String, User> users = new HashMap<>();
    private final UserDao userDao;

    public Collection<User> findAll() {
        return users.values();
    }

    public User create(User user) {
        checkEmail(user);
        if (users.containsKey(user.getId())) {
            throw new UserAlreadyExistsException(String.format(
                    "Пользователь с ID %s уже зарегистрирован.",
                    user.getId()
            ));
        }

        users.put(user.getId(), user);
        return user;
    }

    public User update(User user) {
        checkEmail(user);

        users.put(user.getId(), user);
        return user;
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }

    private void checkEmail(User user) {
        if (user.getId() == null || user.getId().isBlank()) {
            throw new InvalidEmailException("Адрес электронной почты не может быть пустым.");
        }
    }

    public Optional<User> findUserById(String id) {
        if (id == null) {
            return Optional.empty();
        }
        return userDao.findUserById(id);
    }
}