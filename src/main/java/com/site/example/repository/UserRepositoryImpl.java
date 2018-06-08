package com.site.example.repository;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false";
    private static final String userName = "root";
    private static final String password = "12345";
    private static final String insertNew = "INSERT INTO people VALUES(?,?,?)";

    public void saveUserInDataBase(int numberColumn, String nameColumn) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;

        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(insertNew);
            preparedStatement.setString(2, "Alexandr");
            preparedStatement.setString(3, "11111");

            preparedStatement.setString(2, "Andrei");
            preparedStatement.setString(3, "12345");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }
}
