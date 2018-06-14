package com.site.example.controller;

import com.site.example.service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/")
    public String getForm() {
        return "login";
    }

    @PostMapping(value = "/result")
    public String postSubmit(@RequestParam String user, @RequestParam String password, Model model) {
        if (userValidator.validate(user) && userValidator.validatePassword(user, password)) {
            model.addAttribute("user", user);
            return "result";
        } else {
            return "redirect:/error";
        }
    }
}
