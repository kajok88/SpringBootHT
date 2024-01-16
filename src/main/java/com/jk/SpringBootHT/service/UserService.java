package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.User;
import com.jk.SpringBootHT.model.UserDto;

public interface UserService {
    void saveUser(UserDto userDto);
    User findByUsername(String username);
}
