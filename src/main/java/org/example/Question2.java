package org.example;

import java.sql.*;

public class Question2 {

    public static void answer() throws SQLException {
        // 1- Get a connection to DB
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "2135";

        Connection connection = DriverManager.getConnection(dbURL, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT s.first_name, username, password FROM staff s\n" +
                "INNER JOIN store ON store.store_id = s.store_id\n" +
                "INNER JOIN inventory ON inventory.store_id = store.store_id\n" +
                "INNER JOIN film ON film.film_id = inventory.film_id\n" +
                "WHERE title = 'Glass Dying'\n" +
                "LIMIT 1";
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();
        System.out.println(
                resultSet.getString("first_name") + "  " +
                        resultSet.getString("username") + "  " +
                        resultSet.getString("password"));
    }

        }


