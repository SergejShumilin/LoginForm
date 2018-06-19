package com.site.example.service;

import com.site.example.entity.User;
import com.site.example.repository.UserRepository;
import com.site.example.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSaveToDataBaseImpl implements UserSaveToDataBase {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        String hash = MD5.getHash(user.getPassword());
        userRepository.save(user.getUser(), hash);
    }


}
