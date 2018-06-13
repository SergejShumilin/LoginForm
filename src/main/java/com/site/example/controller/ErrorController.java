package com.site.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ErrorController {
    @PostMapping(value = "/error")
    public String postError() {
        return "error";
    }
}
