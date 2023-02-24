package org.example;

import java.sql.*;

public class Question5 {

    public static void answer() throws SQLException{

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "2135";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String firstQuery = "SELECT SUM(f.rental_rate) AS total FROM film f\n" +
                "INNER JOIN inventory i ON i.film_id = f.film_id\n" +
                "WHERE i.store_id = 2";

        ResultSet resultSet = statement.executeQuery(firstQuery);

        int count = 1;
        while (resultSet.next()){
            System.out.println(resultSet.getString("total"));
        }

    }
}
