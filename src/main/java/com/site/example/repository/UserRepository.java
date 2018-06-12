package com.site.example.repository;

public interface UserRepository {
    void saveUserInDataBase(String userName, String password);

    String getByName(String userName);
}
