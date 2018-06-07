package com.site.example;


import com.site.example.connectdatabase.ConnectUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(Application.class, args);

        ConnectUser connectUser = new ConnectUser();
        connectUser.connectDataBaseUser();



    }
}

