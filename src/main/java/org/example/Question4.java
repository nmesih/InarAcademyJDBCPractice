package org.example;

import java.awt.dnd.DragGestureEvent;
import java.sql.*;

public class Question4 {

    public static void answer() throws SQLException{

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "2135";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String firstQuary = "SELECT c.country, SUM(p.amount) AS total FROM payment p\n" +
                "INNER JOIN customer cs ON p.customer_id = cs.customer_id\n" +
                "INNER JOIN address a ON a.address_id = cs.address_id\n" +
                "INNER JOIN city ct ON ct.city_id = a.city_id\n" +
                "INNER JOIN country c ON c.country_id = ct.country_id\n" +
                "GROUP BY c.country\n" +
                "HAVING SUM(p.amount)>800\n" +
                "ORDER BY total DESC";

        ResultSet resultSet = statement.executeQuery(firstQuary);

        int count = 1;
        while (resultSet.next()){
            System.out.println(resultSet.getString("country"));
        }

    }
}
