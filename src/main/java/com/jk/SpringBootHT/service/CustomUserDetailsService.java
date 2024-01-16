//package com.jk.SpringBootHT.service;
//
//import com.jk.SpringBootHT.entity.User;
//import com.jk.SpringBootHT.repository.IUserRepository;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private IUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user != null) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getUsername(),
//                    user.getPasswordHash(),
//                    true,
//                    true,
//                    true,
//                    true,
//                    Arrays.asList(new SimpleGrantedAuthority("USER")));
//        }else{
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//    }
//}
