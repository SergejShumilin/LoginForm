package com.site.example.repository;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepositoryImpl implements UserRepository {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase?autoReconnect=true&useSSL=false";
    private static final String name = "root";
    private static final String passwordToDataBase = "12345";
    private static final String insertNew = "INSERT INTO user VALUES(?,?,?)";

    @Override
    public void saveUserInDataBase(String userName, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, name, passwordToDataBase);
            preparedStatement = connection.prepareStatement(insertNew);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
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

    public String getByName(String userName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;
        String password = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, name, passwordToDataBase);
            preparedStatement = connection.prepareStatement("SELECT password FROM user WHERE name = ?");
            preparedStatement.setString(1, userName);
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
        }
        return password;
    }
}


