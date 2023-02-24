package org.example;

import java.sql.*;

public class Question3 {

    public static void answer() throws SQLException {
        // 1- Get a connection to DB
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "2135";

        Connection connection = DriverManager.getConnection(dbURL, username, password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String firstQuary = "SELECT c.name, COUNT(c.category_id) FROM category c\n" +
        "INNER JOIN film_category fc ON c.category_id = fc.category_id\n" +
                "INNER JOIN film ON fc.film_id = film.film_id\n" +
                "INNER JOIN inventory ON film.film_id = inventory.film_id\n" +
                "WHERE store_id = 1\n" +
                "GROUP BY c.name\n" +
                "HAVING COUNT(c.category_id)>150\n" +
                "ORDER BY COUNT(c.category_id) DESC\n" +
                "LIMIT 5";;

        ResultSet resultSet = statement.executeQuery(firstQuary);

        int count = 1;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
}
