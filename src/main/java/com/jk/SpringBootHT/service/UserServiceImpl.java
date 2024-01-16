package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.User;
import com.jk.SpringBootHT.model.UserDto;
import com.jk.SpringBootHT.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private IUserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        // user.setPasswordHash(passwordEncoder.encode(userDto.getPlainPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }

}
