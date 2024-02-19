package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.model.UserDto;
import com.jk.SpringBootHT.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // return custom login page for spring security
    @GetMapping("/login")
    public String login(){return "login";}


    // handler method to handle user registration form request
    @GetMapping("/signUp")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "sign_up";
    }

    @PostMapping("/signUp/save")
    public String signUp(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If there are validation errors, return to sign-up page
            return "sign_up";
        }

        // Check for an existing username
        if (userService.findByUsername(userDto.getUsername()).isPresent()) {
            model.addAttribute("errorMessage", "Username already taken!");
            return "sign_up";
        }

        // Save user if everything is fine
        try {
            userService.saveUser(userDto);
            model.addAttribute("successMessage", "Sign up success!");
            return "sign_up";
        } catch (RuntimeException e) {
            // Handle other runtime exceptions
            model.addAttribute("errorMessage", "Error during sign up: " + e.getMessage());
            return "sign_up";
        }
    }
}
