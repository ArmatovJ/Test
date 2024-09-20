package com.example.test.mapper;

import com.example.test.dto.UserDto;
import com.example.test.dto.UserRequest;
import com.example.test.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserRequest toUserRequest(User user) {
        UserRequest userRequest = new UserRequest();
        userRequest.setName(user.getName());
        userRequest.setSurname(user.getSurname());
        userRequest.setAge(user.getAge());
        userRequest.setPassword(user.getPassword());
        return userRequest;
    }
    public static User toUser(UserRequest userRequest) {
        User  user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setAge(userRequest.getAge());
        user.setPassword(userRequest.getPassword());
        return user;
    }
    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setAge(user.getAge());
        return userDto;
    }
    public static List<UserDto> toDtoList(List<User> userEntities) {
        return userEntities.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
