package com.upb.agripos.config;

public class DatabaseConnection {
    // Satu-satunya instance yang disimpan
    private static DatabaseConnection instance;

    // Constructor private agar tidak bisa di-new dari luar
    private DatabaseConnection() {
        System.out.println("Database connection created.");
    }

    // Method statis untuk mengambil instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}