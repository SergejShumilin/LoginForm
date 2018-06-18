package com.site.example.service;


import com.site.example.repository.UserRepository;
import com.site.example.util.HashMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Autowired
    UserRepository userRepository;

    HashMD5 hashMD5;

    @Override
    public boolean validate(String value) {
        int length = value.length();
        return length > 4 && length < 9;
    }

    @Override
    public boolean validatePassword(String value, String password) {
        String hashPassword = hashMD5.getHash(password);
        String passwordFromDB = userRepository.getPasswordByName(value);
        return hashPassword.equals(passwordFromDB);
    }
}
