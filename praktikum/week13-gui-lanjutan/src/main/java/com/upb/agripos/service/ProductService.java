package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.ArrayList;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- BARU: Untuk Hapus ---
    public void deleteProduct(String code) {
        try {
            productDAO.delete(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- BARU: Untuk Load Table ---
    public List<Product> findAll() {
        try {
            return productDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}