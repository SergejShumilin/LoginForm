package com.site.example.controller;

import com.site.example.services.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerSite {

    @Autowired
    private UserValidate userValidate;

    @GetMapping("/index")
    public String greeting() {
        return "index";
    }


    @PostMapping(value = "/result")
    public String postSubmit(@RequestParam String user,@RequestParam String password, Model model) {
        if (userValidate.validate(user) && userValidate.validate(password)){
            model.addAttribute("user", user);
            return "result";
        } else return "error";


    }

}
