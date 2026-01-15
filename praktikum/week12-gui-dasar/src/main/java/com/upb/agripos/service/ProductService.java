package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        try {
            // --- KONEKSI DATABASE XAMPP (Sama seperti Week 11) ---
            String url = "jdbc:mysql://localhost:3306/agripos";
            String user = "root";
            String password = ""; 
            
            Connection conn = DriverManager.getConnection(url, user, password);
            this.productDAO = new ProductDAOImpl(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addProduct(String code, String name, double price, int stock) {
        try {
            Product p = new Product(code, name, price, stock);
            productDAO.insert(p);
            System.out.println("Service: Berhasil simpan produk ke database");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Service: Gagal simpan - " + e.getMessage());
        }
    }
}