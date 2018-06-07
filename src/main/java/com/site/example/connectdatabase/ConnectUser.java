package com.site.example.connectdatabase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class ConnectUser {

    private static final String url = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false";
    private static final String userName = "root";
    private static final String password = "12345";
    private static final String InsertNew = "INSERT INTO users VALUES(?,?,?)";

    public void connectDataBaseUser() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(url, userName, password);
        preparedStatement = connection.prepareStatement(InsertNew);
//        preparedStatement.setInt(1,1);
//        preparedStatement.setString(2, "Andrei");
//        preparedStatement.setString(3, "12345");
//        preparedStatement.execute();
//        preparedStatement.setInt(1,2);
        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "Alexandr");
        preparedStatement.setString(3, "11111");
        preparedStatement.execute();


//    String url = "jdbc:mysql://localhost:3306/user?autoReconnect=true&useSSL=false";
//    String userName = "root";
//    String password = "12345";
//        Class.forName("com.mysql.jdbc.Driver");
//        try (Connection con = DriverManager.getConnection(url, userName, password);
//    Statement statement = con.createStatement()) {
//            statement.executeUpdate("drop table Users");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Users (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30), password CHAR(8), PRIMARY KEY (id))");
//            statement.executeUpdate("insert into Users (name, password) values('Admin', '1')");
//        }
    }
}
