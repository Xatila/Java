package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username default (root): ");
        String user = sc.nextLine();
        user = user.equals("") ? "root" : user;
        System.out.println();

        System.out.print("Enter password default (empty):");
        String password = sc.nextLine().trim();
        System.out.println();

        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT user_name, first_name, last_name, COUNT(users_games.id) AS couunt FROM users" + " JOIN users_games ON users.id=users_games.user_id" + " WHERE user_name = ?" + " GROUP BY users_games.user_id");

        String last_name = sc.nextLine();
        stmt.setString(1, (last_name));
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("User: " + last_name + "\n" + rs.getString("first_name") + " " +
                    rs.getString("last_name") + " has played " + rs.getInt("couunt") + " games");
        }else {
            System.out.println("No such user exists");
        }
        connection.close();
    }
}