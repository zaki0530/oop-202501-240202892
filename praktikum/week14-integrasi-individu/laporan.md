# Laporan Praktikum Week 14 – Integrasi Individu (Agri-POS)

## Identitas
- **Nama** : Abu Zaki
- **NIM** : 240202892
- **Kelas** : OOP

---

## A. Ringkasan Aplikasi
Agri-POS adalah aplikasi kasir pertanian berbasis desktop (JavaFX) yang mengintegrasikan konsep OOP, Database, dan GUI. Aplikasi ini memiliki dua fitur utama:
1. **Manajemen Produk (CRUD)**: Admin dapat melihat, menambah, dan menghapus data produk yang tersimpan di database PostgreSQL/MySQL.
2. **Transaksi Kasir (Keranjang)**: Kasir dapat memilih produk, memasukkan jumlah beli, dan sistem akan menghitung total harga secara otomatis menggunakan logika keranjang belanja (Collections).

---

## B. Integrasi Konsep (Bab 1–13)
Aplikasi ini menggabungkan materi-materi berikut:
1. **OOP Basic**: Penggunaan Class `Product` dan `CartItem` sebagai Model.
2. **Collections (Bab 7)**: Menggunakan `List<CartItem>` pada `CartService` untuk menampung belanjaan sementara.
3. **Exception Handling (Bab 9)**: Validasi input (stok minus, input huruf) menggunakan custom exception `ValidationException`.
4. **Design Pattern (Bab 10)**: Menggunakan **Singleton Pattern** pada class `DatabaseHelper` untuk efisiensi koneksi database.
5. **DAO + JDBC (Bab 11)**: Akses data terpisah di layer `dao` (`JdbcProductDAO`) tanpa mencampur SQL di layer tampilan.
6. **GUI JavaFX (Bab 12-13)**: Antarmuka pengguna berbasis Event-Driven dengan `TableView` dan pemisahan layer MVC.

---

## C. Tabel Traceability

| Artefak | Referensi | Handler / Trigger | Controller / Service | DAO | Dampak |
|---|---|---|---|---|---|
| **Use Case** | UC-01 Tambah Produk | Tombol "Tambah Produk" | `PosController.saveProduct()` → `ProductService.addProduct()` | `JdbcProductDAO.insert()` | Data tersimpan di DB & Tabel Refresh |
| **Use Case** | UC-02 Hapus Produk | Tombol "Hapus" | `PosController.deleteProduct()` → `ProductService.deleteProduct()` | `JdbcProductDAO.delete()` | Data hilang dari DB |
| **Activity** | AD-01 Masuk Keranjang | Tombol "Masuk Keranjang" | `PosController.addToCart()` → `CartService.addItem()` | - | Item masuk ke List memori & Tabel Kanan update |
| **Sequence** | SD-01 Hitung Total | Loop Keranjang | `CartService.getTotal()` → `Cart.calculateGrandTotal()` | - | Label Total Harga berubah sesuai jumlah barang |

---

## D. Hasil Eksekusi & Testing

**1. Tampilan Utama Aplikasi**
Fitur CRUD (Kiri) dan Keranjang Belanja (Kanan) berjalan dalam satu window.
![App Main] ![alt text](<Screenshot (162).png>) ![alt text](<Screenshot (169)-1.png>) ![alt text](<Screenshot (160).png>)
**2. Hasil Unit Testing (Manual JUnit)**
Pengujian logika `CartService` untuk memastikan perhitungan total dan validasi stok berjalan benar sebelum diintegrasikan ke GUI.
![JUnit Result] ![alt text](<Screenshot (169).png>)

---

## E. Kendala & Solusi
1. **Kendala**: Error `JavaFX runtime components are missing` saat menjalankan file AppJavaFX secara langsung.
   **Solusi**: Membuat file `Launcher.java` sebagai pemancing (*workaround*) agar JDK memuat module JavaFX dengan benar sebelum aplikasi dimulai.
   
2. **Kendala**: Kesulitan sinkronisasi antara TableView Produk (Database) dan Keranjang (Memory).
   **Solusi**: Memisahkan logika menjadi dua service berbeda (`ProductService` untuk DB, `CartService` untuk Memory), lalu disatukan di dalam satu Controller (`PosController`).

---