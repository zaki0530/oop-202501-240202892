package com.upb.agripos;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;

public class AppMVC {
    public static void main(String[] args) {
        // GANTI DENGAN NAMA ANDA
        System.out.println("Hello, I am [Abu Zaki]-[240202892] (Week10)");
        
        // 1. Test Singleton
        System.out.println("--- Test Singleton ---");
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        // db1 dan db2 harusnya objek yang sama

        // 2. Test MVC
        System.out.println("\n--- Test MVC ---");
        Product product = new Product("P01", "Pupuk Organik");
        ConsoleView view = new ConsoleView();
        
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}