package com.site.example.service;

import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {
    public boolean validate(String value){
        int length = value.length();
        return length > 4 && length < 8;
    }
}
