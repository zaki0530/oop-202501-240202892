package com.upb.agripos;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;

public class MainDAOTest {
    public static void main(String[] args) {
        // GANTI NAMA & NIM ANDA DI SINI
        System.out.println("Hello, I am [Abu Zaki]-[240202892] (Week11 - MySQL)");

        // --- SETTINGAN KHUSUS XAMPP ---
        String url = "jdbc:mysql://localhost:3306/agripos"; 
        String user = "root"; 
        String password = ""; // Password default XAMPP memang kosong
        // ------------------------------

        try {
            // 1. Buat Koneksi
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi Database (MySQL XAMPP) Berhasil!");

            ProductDAO dao = new ProductDAOImpl(conn);

            // 2. CREATE (Insert)
            System.out.println("\n--- Test Insert ---");
            // Cek dulu biar gak error kalau data sudah ada
            if (dao.findByCode("P01") == null) {
                Product p1 = new Product("P01", "Bibit Padi", 50000, 100);
                dao.insert(p1);
                System.out.println("Insert Berhasil: " + p1.getName());
            } else {
                System.out.println("Data P01 sudah ada, skip insert.");
            }

            // 3. READ (FindByCode)
            System.out.println("\n--- Test Read ---");
            Product found = dao.findByCode("P01");
            if (found != null) {
                System.out.println("Ditemukan: " + found.getName() + " | Harga: " + found.getPrice());
            }

            // 4. UPDATE
            System.out.println("\n--- Test Update ---");
            if (found != null) {
                found.setName("Bibit Padi Unggul");
                found.setPrice(55000);
                dao.update(found);
                System.out.println("Update Berhasil jadi: " + found.getName());
            }

            // 5. DELETE
            System.out.println("\n--- Test Delete ---");
            dao.delete("P01");
            System.out.println("Delete Berhasil.");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Gagal koneksi: " + e.getMessage());
        }
    }
}