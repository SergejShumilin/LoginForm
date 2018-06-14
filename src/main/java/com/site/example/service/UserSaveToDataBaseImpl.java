package com.site.example.service;

import com.site.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaveToDataBaseImpl implements UserSaveToDataBase {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean saveUser(String value, String password) {
        return userRepository.save(value, password);

    }
}
