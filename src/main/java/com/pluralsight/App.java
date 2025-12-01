package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "";

        //1. open a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

    }
}
