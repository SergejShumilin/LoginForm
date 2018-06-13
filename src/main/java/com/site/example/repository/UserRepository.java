package com.site.example.repository;

public interface UserRepository {
    void save(String name, String password);

    String getByName(String name);
}
