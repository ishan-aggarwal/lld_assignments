package com.scaler.repositories;

import com.scaler.models.User;

import java.util.*;


public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(users.size() + 1);
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(long id) {
        return Optional.ofNullable(users.get(id));
    }
}
