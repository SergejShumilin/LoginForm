package com.site.example.service;

public interface UserValidator {
    boolean validate(String value);

    boolean validatePassword(String value, String password);
}

