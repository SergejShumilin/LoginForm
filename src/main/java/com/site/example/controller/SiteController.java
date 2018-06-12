package com.site.example.controller;

import com.site.example.service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteController {

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/index")
    public String getForm() {
        return "index";
    }


    @PostMapping(value = "/r")//uri
    public String postSubmit(@RequestParam String user, @RequestParam String password, Model model) {
        if (userValidator.validate(user) && userValidator.validatePassword(user, password)) {
            model.addAttribute("user", user);
            return "result";//html name
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping(value = "/registration")
    public String postRegistration() {

        return "registration";
    }
    @PostMapping(value = "/error")
    public String postError() {
        return "error";
    }


}
