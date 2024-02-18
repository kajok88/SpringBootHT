package com.jk.SpringBootHT.service;

import com.jk.SpringBootHT.entity.Role;
import com.jk.SpringBootHT.entity.User;
import com.jk.SpringBootHT.model.UserDto;
import com.jk.SpringBootHT.repository.IRoleRepository;
import com.jk.SpringBootHT.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Long getUserIdByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(User::getUserId).orElse(null);
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPasswordHash(passwordEncoder.encode(userDto.getPlainPassword()));

        Role roles = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singleton(roles));
        userRepository.save(user);



//        Set<Role> roles = user.getRoles();
//        if (roles == null || roles.isEmpty()) {
//            Optional<Role> userRole = roleRepository.findByName("ROLE_USER");
//            if (userRole.isEmpty()) {
//                // Create ROLE_USER if it doesn't exist
//                userRole = Optional.of(new Role("ROLE_USER"));
//                roleRepository.save(userRole);
//            }
//            roles = new HashSet<>();
//            roles.add(userRole);
//            user.setRoles(roles);
//        }
//        userRepository.save(user);
    }


//    private Role createRole(){
//        Role role = new Role();
//        role.setName("ROLE_USER");
//        return roleRepository.save(role);
//    }


    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }

}
