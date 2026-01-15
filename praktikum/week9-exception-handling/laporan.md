## 2. Laporan Week 9 (Exception Handling)

## Identitas
- Nama  : Abu Zaki
- NIM   : 240202892
- Kelas : OOP

---

## A. Tujuan Pembelajaran
1. Menjelaskan perbedaan antara error dan exception.
2. Mengimplementasikan try–catch–finally dengan tepat.
3. Membuat custom exception sesuai kebutuhan program.

---

## Dasar Teori
1. **Exception**: Kondisi abnormal yang terjadi saat program berjalan yang dapat ditangani agar program tidak berhenti mendadak (crash).
2. **Try-Catch**: Blok kode untuk menangkap exception. `Try` berisi kode yang berpotensi error, `Catch` berisi penanganan error tersebut.
3. **Custom Exception**: Class exception buatan sendiri yang mewarisi class `Exception`, digunakan untuk menangani validasi bisnis yang spesifik.

---

## Langkah Praktikum
1. **Membuat Exception**: Membuat 3 file class exception (`InvalidQuantity`, `ProductNotFound`, `InsufficientStock`).
2. **Update Model**: Menambahkan atribut `stock` pada class `Product`.
3. **Validasi**: Menambahkan kata kunci `throws` pada method di `ShoppingCart` dan logika pengecekan `if`.
4. **Testing**: Menjalankan simulasi error di `MainExceptionDemo` menggunakan blok try-catch.

---

## Kode Program
InvalidQuantityException.java
package com.upb.agripos;

public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String msg) { 
        super(msg); 
    }
}
## Hasil Eksekusi
![](<Screenshot (156).png>)
## Analisis
Cara Kerja: Saat user memasukkan input yang salah (misal minus), program akan "melempar" (throw) exception. Blok catch kemudian menangkapnya dan menampilkan pesan error yang rapi, sehingga program tidak force close.

Perbedaan: Minggu ini fokus pada ketahanan program (robustness), bukan hanya logika fungsional.

Kendala: Menyesuaikan file Product.java yang berbeda versi dengan minggu sebelumnya, diatasi dengan mengupdate constructor Product agar memiliki stok.

## Kesimpulan
Exception handling sangat krusial dalam aplikasi POS untuk mencegah data yang tidak valid masuk ke sistem (seperti stok minus). Custom exception membantu programmer memahami jenis kesalahan spesifik yang terjadi.

## Quiz
Jelaskan perbedaan error dan exception. Jawaban: Error adalah masalah serius dari sistem (seperti OutOfMemory) yang sulit dipulihkan, sedangkan Exception adalah masalah logika program (seperti NullPointer) yang bisa ditangani dengan try-catch.

Apa fungsi finally dalam blok try–catch–finally? Jawaban: Blok finally berisi kode yang akan SELALU dijalankan baik terjadi error maupun tidak, biasanya digunakan untuk menutup koneksi atau membersihkan resource.

Mengapa custom exception diperlukan? Jawaban: Agar pesan kesalahan lebih spesifik dan sesuai dengan bahasa bisnis aplikasi (contoh: "Stok Tidak Cukup" lebih jelas daripada error umum Java).