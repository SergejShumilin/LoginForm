package com.site.example.repository;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepositoryImpl implements UserRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD_TO_DATA_BASE = "12345";
    private static final String INSERT_NEW = "INSERT INTO user VALUES(?,?,?)";
    private static final String SELECT_NEW = "SELECT password FROM user WHERE name = ?";

    @Override
    public void save(String name, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD_TO_DATA_BASE);
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;
        String password = null;
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD_TO_DATA_BASE);
            preparedStatement = connection.prepareStatement(SELECT_NEW);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return password;
        }
    }
}