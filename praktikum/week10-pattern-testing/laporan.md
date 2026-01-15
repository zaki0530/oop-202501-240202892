## Laporan Week 10 (Design Pattern)

## Identitas
- Nama  : Abu Zaki
- NIM   : 240202892
- Kelas : OOP

---

## A. Tujuan Pembelajaran
1. Menerapkan Design Pattern Singleton.
2. Mengimplementasikan arsitektur MVC (Model-View-Controller).
3. Memisahkan logika aplikasi menjadi komponen yang terstruktur.

---

## Dasar Teori
1. **Design Pattern**: Solusi umum yang dapat digunakan kembali untuk masalah yang sering muncul dalam desain perangkat lunak.
2. **Singleton Pattern**: Pola desain yang memastikan sebuah class hanya memiliki satu *instance* (objek) saja selama aplikasi berjalan.
3. **MVC (Model-View-Controller)**: Pola arsitektur yang memisahkan data (Model), tampilan (View), dan logika pengontrol (Controller).

---

## Langkah Praktikum
1. **Refactoring**: Mengelompokkan file java ke dalam package `model`, `view`, `controller`, dan `config`.
2. **Singleton**: Membuat class `DatabaseConnection` dengan method `getInstance`.
3. **MVC**: Memisahkan kode `Product` (data), `ConsoleView` (tampilan), dan `ProductController` (logika).
4. **Testing**: Menjalankan `AppMVC.java` untuk menguji struktur baru.

---

## Kode Program
DatabaseConnection.java
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
## Hasil Eksekusi
![](<Screenshot (144).png>)
## Analisis
Cara Kerja: Aplikasi dimulai dari AppMVC yang memanggil Controller. Controller mengambil data dari Model dan mengirimkannya ke View untuk ditampilkan.

Perbedaan: Kode menjadi jauh lebih rapi karena terpisah-pisah (Separation of Concerns).

Kendala: Sempat terjadi error package saat memindahkan file ke folder baru, diatasi dengan fitur "Quick Fix" di VS Code dan Clean Workspace.

## Kesimpulan
Penerapan Design Pattern dan MVC membuat kode program lebih mudah dipelihara (maintainable) dan dikembangkan (scalable). Singleton sangat efektif untuk menghemat penggunaan memori pada objek koneksi.

## Quiz
1. Apa tujuan utama dari Singleton Pattern? Jawaban: Untuk membatasi instansiasi class menjadi satu objek saja dan menyediakan satu titik akses global ke objek tersebut.

2. Jelaskan peran Controller dalam MVC! Jawaban: Controller bertindak sebagai penghubung antara Model dan View. Ia menerima input, memproses data logika bisnis, dan menentukan tampilan apa yang akan dikeluarkan.

3. Sebutkan keuntungan menggunakan MVC! Jawaban: Kode lebih terorganisir, memudahkan kerja tim (frontend/backend terpisah), dan mempermudah testing