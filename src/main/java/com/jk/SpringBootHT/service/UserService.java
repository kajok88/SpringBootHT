package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.User;
import com.jk.SpringBootHT.model.UserDto;

import java.util.Optional;

public interface UserService {
    void saveUser(UserDto userDto);
    Optional<User> findByUsername(String username);
}
