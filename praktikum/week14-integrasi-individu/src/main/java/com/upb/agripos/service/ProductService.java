package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.model.Product;
import com.upb.agripos.util.DatabaseHelper;
import java.util.List;
import java.util.ArrayList;

public class ProductService {
    private ProductDAO dao;

    public ProductService() {
        // Menggunakan Singleton Connection
        this.dao = new JdbcProductDAO(DatabaseHelper.getConnection());
    }

    public List<Product> findAll() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void addProduct(String code, String name, double price, int stock) throws ValidationException {
        // Validasi Custom (Bab 9)
        if (code.isEmpty() || name.isEmpty()) throw new ValidationException("Kode/Nama tidak boleh kosong!");
        if (price < 0) throw new ValidationException("Harga tidak boleh negatif!");
        if (stock < 0) throw new ValidationException("Stok tidak boleh negatif!");

        try {
            dao.insert(new Product(code, name, price, stock));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ValidationException("Gagal simpan ke database: " + e.getMessage());
        }
    }

    public void deleteProduct(String code) {
        try { dao.delete(code); } catch (Exception e) { e.printStackTrace(); }
    }
}