package com.example.test.service;

import com.example.test.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserByName(String name);
    User getUserById(Long id);
    List<User> getAllUsers();
    boolean updateUser(Long id);
    boolean deleteUser(Long id);

}
