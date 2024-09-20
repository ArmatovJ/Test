package com.example.test.controller;


import com.example.test.dto.UserDto;
import com.example.test.dto.UserRequest;
import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import com.example.test.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @PostMapping(value = "/create-user")
    public String create(@RequestBody UserRequest user) {
        User newUser = UserMapper.toUser(user);
        userService.createUser(newUser);
        return "User created";
    }

    @GetMapping(value = "/get-user-by-name")
    public UserDto getUserByName(@RequestParam String name) {
        User user = userService.getUserByName(name);
        return UserMapper.toUserDto(user);
    }

    @GetMapping(value = "/get-user-by-id")
    public UserDto getUserById(@RequestParam Long id) {
        User user = userService.getUserById(id);
        return UserMapper.toUserDto(user);
    }

    @GetMapping(value = "/get-all-users")
    public List<UserDto> getAllUsers() {
        return UserMapper.toDtoList(userService.getAllUsers());
    }

    @PostMapping(value = "/update")
    public String update(@RequestParam Long id) {
        boolean isUpdate = userService.updateUser(id);
        if(!isUpdate){
            return "User NOT updated!";
        }
        return "User updated";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long id) {
        boolean isUpdate = userService.deleteUser(id);
        if(!isUpdate){
            return "User NOT deleted!";
        }
        return "User deleted";
    }

}
