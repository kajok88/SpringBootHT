package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.User;

public interface UserService {
    void saveUser(User user);
    User findByUsername(String username);
}
