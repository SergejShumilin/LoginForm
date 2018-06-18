package com.site.example.service;

import com.site.example.repository.UserRepository;
import com.site.example.util.HashMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaveToDataBaseImpl implements UserSaveToDataBase {
    @Autowired
    UserRepository userRepository;

    @Override
    public void save(String value, String password) {
        String hash = HashMD5.getHash(password);
        userRepository.save(value, hash);
    }


}
