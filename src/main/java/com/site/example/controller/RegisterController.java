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

    @GetMapping("/registr")
    public String getFormRegistration() {
        return "registration";
    }

    @PostMapping(value = "/login")
    public String postRegistration(@RequestParam String user, @RequestParam String password) {
        userSaveToDataBase.save(user, password);
        return "login";
    }
}
