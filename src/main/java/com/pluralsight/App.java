package com.pluralsight;

import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = args[0];
        String password = args[1];

        //1. open a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();

        // define your query
        String query = """
                        SELECT title, description, release_year, length
                        FROM film; 
                        """;

        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);

       // process the results
        while (results.next()) {
            String title = results.getString("title");
            String description = results.getString("description");
            int releaseYear = results.getInt("release_year");
            int length = results.getInt("length");

            System.out.println(title);
            System.out.println(description);
            System.out.println(releaseYear);
            System.out.println(length);
            System.out.println("-----------------------");
        }

        // 3. Close the connection
        connection.close();



    }
}
