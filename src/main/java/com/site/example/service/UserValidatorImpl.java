package com.site.example.service;

import com.site.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Autowired
    private UserRepository userRepository;


    public boolean validate(String value) {
        int length = value.length();
        return length > 4 && length < 8;
    }

    @Override
    public boolean validatePassword(String userName, String password) {
        String passwordFromDB = userRepository.getByName(userName);
        return password.equals(passwordFromDB);
    }
}
