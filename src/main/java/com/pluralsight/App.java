package com.pluralsight;

import java.sql.*;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = args[0];
        String password = args[1];

        displayFilms(url, username, password);
        displayActors(url, username, password);


    }

    private static void displayFilms(String url, String username, String password) {
        String query = """
                SELECT title, description, release_year, length
                FROM film
                WHERE title LIKE ?
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            String searchTerm = "%AIR%";
            statement.setString(1, searchTerm);

            try (ResultSet results = statement.executeQuery()) {

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
            }

        } catch (SQLException e) {
            System.out.println("There was an error retrieving the data. Please try again.");
            e.printStackTrace();
        }
    }

    private static void displayActors(String url, String username, String password) {
        String query = """
                SELECT first_name, last_name
                FROM actor
                WHERE last_name LIKE ?
                """;

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            String searchTerm = "S%";
            statement.setString(1, searchTerm);

            try (ResultSet results = statement.executeQuery()) {

                while (results.next()) {
                    String firstName = results.getString("first_name");
                    String lastName = results.getString("last_name");


                    System.out.println(firstName);
                    System.out.println(lastName);

                    System.out.println("-----------------------");
                }
            }

        } catch (SQLException e) {
            System.out.println("There was an error retrieving the data. Please try again.");
            e.printStackTrace();
        }
    }
}
