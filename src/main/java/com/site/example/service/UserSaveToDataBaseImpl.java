package com.site.example.service;

import com.site.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaveToDataBaseImpl implements UserSaveToDataBase {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(String value, String password) {
        userRepository.save(value, password);

    }
}
