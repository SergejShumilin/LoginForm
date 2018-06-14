package com.site.example.controller;

import com.site.example.service.UserSaveToDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    @Autowired
    private UserSaveToDataBase userSaveToDataBase;

    @GetMapping("/")
    public String getFormRegistration() {
        return "registration";
    }

    @PostMapping(value = "/register")
    public String postRegistration(@RequestParam String name, @RequestParam String password) {
        if (userSaveToDataBase.saveUser(name, password)) {
            return "login";
        } else {
            return "redirect:/error";
        }
    }
}
