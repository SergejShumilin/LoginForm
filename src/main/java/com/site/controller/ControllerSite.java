package com.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerSite {
    @GetMapping("/index")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }


    @PostMapping(value = "/index")
    public String greetingSubmit(@RequestParam String content, Model model) {
        model.addAttribute("aaa", model);
        return "result";
    }

}
