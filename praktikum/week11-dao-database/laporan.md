## 4. Laporan Week 11 (DAO & Database)

## Identitas
- Nama  : Abu Zaki
- NIM   : 240202892
- Kelas : OOP

---

## A. Tujuan Pembelajaran
1. Menjelaskan konsep Data Access Object (DAO).
2. Menghubungkan aplikasi Java dengan basis data MySQL menggunakan JDBC.
3. Mengimplementasikan operasi CRUD (Create, Read, Update, Delete).

---

## Dasar Teori
1. **DAO (Data Access Object)**: Pola desain yang memisahkan logika akses data tingkat rendah (SQL) dari logika bisnis tingkat tinggi.
2. **JDBC (Java Database Connectivity)**: API standar Java untuk menghubungkan dan mengeksekusi query ke database.
3. **CRUD**: Empat operasi dasar database persisten (Create, Read, Update, Delete).

---

## Langkah Praktikum
1. **Setup Database**: Instalasi XAMPP, start MySQL, dan membuat database `agripos` via phpMyAdmin.
2. **Library**: Menambahkan driver `mysql-connector-j` ke VS Code.
3. **Coding DAO**: Membuat interface `ProductDAO` dan implementasinya `ProductDAOImpl`.
4. **Main Test**: Membuat `MainDAOTest` untuk menguji koneksi dan operasi CRUD.

---

## Kode Program
MainDAOTest.java
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
## Hasil Eksekusi
![alt text](<Screenshot (154).png>)
## Analisis
Cara Kerja: Java menggunakan JDBC Driver sebagai jembatan ke MySQL. PreparedStatement digunakan untuk mengirim query SQL secara aman.

Perbedaan: Data kini tersimpan permanen di Database (Harddisk), bukan di RAM. Jika aplikasi direstart, data tetap ada.

Kendala: Instalasi PostgreSQL memakan kuota besar, sehingga diganti menggunakan MySQL (XAMPP). Perubahan kode hanya pada URL JDBC dan Driver.

## Kesimpulan
Penggunaan DAO membuat kode aplikasi bersih dari query SQL yang rumit. Integrasi dengan Database memungkinkan aplikasi menyimpan data secara permanen (persisten) yang merupakan syarat utama aplikasi nyata