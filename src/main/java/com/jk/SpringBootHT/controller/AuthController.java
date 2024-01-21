package com.jk.SpringBootHT.controller;

import com.jk.SpringBootHT.entity.User;
import com.jk.SpringBootHT.model.UserDto;
import com.jk.SpringBootHT.repository.IUserRepository;
import com.jk.SpringBootHT.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private IUserRepository userRepository;

    // handler method to handle home page request
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }

    // handler method to handle user registration form request
    @GetMapping("/signUp")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "sign_up";
    }

//    @PostMapping("/signUp/save")
//    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
//                               @RequestParam("username") String newUsername,
//                               Model model, BindingResult result){
//
//        User existingUser = userService.findByUsername(newUsername);
//        if(existingUser != null && existingUser.getUsername() != null){
//            result.rejectValue("username", "error.username",
//                    "That username is already taken");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", userDto);
//            return "sign_up";
//        }
//
//        userService.saveUser(userDto);
//        return "redirect:/signUp?success";
//    }
    @PostMapping("/signUp/save")
    public String signUp(@Valid @ModelAttribute("user") UserDto userDto, Model model, BindingResult result) {
        // Your existing code to check username availability
        if (userService.findByUsername(userDto.getUsername()) != null) {
            model.addAttribute("errorMessage", "Username already taken!");
            return "sign_up";
        }

        // Still gives whitelabel error page when inputting empty fields, WIP
        try {
            userService.saveUser(userDto);

            model.addAttribute("successMessage", "Sign up success!");
            return "sign_up";
        } catch (RuntimeException e){
            if(result.hasErrors()){
                model.addAttribute("successMessage", result.getAllErrors());
                return "sign_up";
            }
        }
        return "sign_up";
    }
//    @PostMapping("/signUp/save")
//    public ResponseEntity<String> signUp(@RequestBody UserDto userDto){
//        if (userRepository.findByUsername(userDto.getUsername()) != null) {
//            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
//        }
//        User user = new User();
//        user.setUsername(userDto.getUsername());
//        user.setPasswordHash(userDto.getPlainPassword());
//        userRepository.save(user);
//
//        return new ResponseEntity<>("User sign up success!", HttpStatus.OK);
//    }
}
