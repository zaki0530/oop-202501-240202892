package com.upb.agripos.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Pastikan XAMPP nyala
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agripos", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}