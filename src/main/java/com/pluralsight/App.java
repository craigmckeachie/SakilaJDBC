package com.pluralsight;

import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "root";
        String password = "";

        //1. open a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();

        // define your query
        String query = "SELECT city FROM city ";

        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);

       // process the results
        while (results.next()) {
            String city = results.getString("city");
            System.out.println(city);
        }

        // 3. Close the connection
        connection.close();



    }
}
