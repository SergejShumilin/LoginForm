package com.site.example.controller;

import com.site.example.services.UserValidater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerSite {

    @Autowired
    private UserValidater userValidater;

    @GetMapping("/index")
    public String getForm() {
        return "index";
    }


    @PostMapping(value = "/result")
    public String postSubmit(@RequestParam String user, @RequestParam String password, Model model) {
        if (userValidater.validate(user) && userValidater.validate(password)) {
            model.addAttribute("user", user);
            return "result";
        } else {
            return "redirect:/error";
        }

    }

    @PostMapping(value = "/error")
    public String postError() {
        return "error";
    }


}
