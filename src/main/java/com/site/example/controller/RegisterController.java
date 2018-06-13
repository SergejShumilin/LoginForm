package com.site.example.controller;

import com.site.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String getFormRegistration() {
        return "registration";
    }

    @PostMapping(value = "/register")
    public String postRegistration(@RequestParam String name, @RequestParam String password) {
        userRepository.save(name, password);
        return "login";
    }
}
