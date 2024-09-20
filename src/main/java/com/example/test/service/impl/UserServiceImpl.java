package com.example.test.service.impl;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    // Сохранение пользователя
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        return save(user);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public boolean updateUser(Long id) {
        User user = getUserById(id);
        userRepository.save(user);
        return true;
    }

    @Transactional
    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
