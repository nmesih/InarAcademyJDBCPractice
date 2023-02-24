package org.example;

import java.sql.*;

public class Questionx {

    //SELECT ROUND(AVG(amount),2) AS average_transaction_amount FROM payment;
    public static void answer() throws SQLException {
        // 1- Get a connection to DB
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password= "2135";
        Connection connection = DriverManager.getConnection(dbURL,username,password);
        // 2- create a statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // 3- execute a query
        String firstQuery = "SELECT ROUND(AVG(amount),2) AS average_transaction_amount FROM payment";
        ResultSet resultSet = statement.executeQuery(firstQuery);
        // 4- process the resultset

        int count = 1;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("average_transaction_amount"));
        }
    }
}
