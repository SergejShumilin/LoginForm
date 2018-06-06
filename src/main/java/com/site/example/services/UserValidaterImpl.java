package com.site.example.services;

import org.springframework.stereotype.Component;

@Component
public class UserValidaterImpl implements UserValidater {
    public boolean validate(String value){
        int length = value.length();
        if(length > 4 && length < 8) {
            return true;
        }
        else return false;
    }
}
