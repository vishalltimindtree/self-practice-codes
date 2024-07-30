package com.day10session2.shopping.service;

import org.springframework.stereotype.Service;

import com.day10session2.shopping.exception.InvalidInputException;
import com.day10session2.shopping.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void registerUser(User user) throws InvalidInputException {
        if (user.getUsername() == null || user.getPassword() == null) {
            throw new InvalidInputException("Invalid user input. Username and password are required.");
        }
        users.add(user);
    }
}
