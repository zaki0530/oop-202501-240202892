# Laporan Praktikum Week 7 - Java Collection Framework

## Identitas
- Nama  : Abu Zaki
- NIM   : 240202892
- Kelas : OOP

---

## A. Tujuan Pembelajaran
1. Memahami penggunaan `ArrayList` untuk menyimpan daftar objek.
2. Memahami penggunaan `HashMap` untuk menyimpan pasangan Key-Value.
3. Mengimplementasikan logika keranjang belanja sederhana.

---

## Dasar Teori
1. **Collection Framework**: Kumpulan interface dan class di Java untuk menyimpan dan memanipulasi sekelompok data (objek) secara dinamis.
2. **ArrayList**: Implementasi dari interface List yang ukurannya dapat berubah secara dinamis (resizable array).
3. **HashMap**: Implementasi dari interface Map yang menyimpan data dalam pasangan *Key* (kunci unik) dan *Value* (nilai), sangat cepat untuk pencarian data.

---

## Langkah Praktikum
1. **Persiapan**: Membuat project baru dan package `com.upb.agripos`.
2. **Coding Model**: Membuat class `Product` sebagai objek data.
3. **Coding Logic**: Membuat class `ShoppingCart` menggunakan `ArrayList` untuk riwayat dan `HashMap` untuk menghitung jumlah item.
4. **Running**: Membuat class main untuk simulasi input produk dan menampilkan hasilnya.
5. **Git**: Melakukan commit dengan pesan "week7-koleksi: implementasi arraylist dan hashmap".

---

## Kode Program
ShoppingCart.java
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    // Menyimpan daftar produk menggunakan ArrayList
    private final ArrayList<Product> items = new ArrayList<>();

    // Perhatikan nama method ini: addProduct (bukan addProduk)
    public void addProduct(Product p) { 
        items.add(p); 
    }

    // Perhatikan nama method ini: removeProduct (bukan removeProduk)
    public void removeProduct(Product p) { 
        items.remove(p); 
    }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
        System.out.println("-------------------------");
    }
}
## HASUL EKSEKUSI
![](<Screenshot (155).png>)
## ANALISIS
(Cara Kerja: Program menggunakan HashMap untuk menyimpan stok di keranjang. Saat produk yang sama ditambahkan, program tidak membuat baris baru, melainkan mengupdate "Value" (jumlahnya) saja.

Perbedaan: Dibandingkan minggu sebelumnya yang menggunakan Array biasa ([]), ArrayList dan HashMap jauh lebih fleksibel karena kita tidak perlu menentukan ukuran awal (size) keranjang.

Kendala: Awalnya bingung membedakan List dan Map, namun teratasi dengan memahami bahwa Map butuh kunci (Key) untuk menyimpan nilai.)
## KESIMPULAN
(Penggunaan Java Collection Framework, khususnya ArrayList dan HashMap, sangat memudahkan pengelolaan data yang jumlahnya dinamis. Struktur data ini lebih efisien untuk kasus keranjang belanja dibandingkan Array konvensional.)
## QUIZ
1. Apa perbedaan Array dan ArrayList? Jawaban: Array memiliki ukuran tetap (fixed size) yang ditentukan saat pembuatan, sedangkan ArrayList bersifat dinamis (bisa membesar/mengecil otomatis) dan menyediakan banyak method bawaan untuk manipulasi data.

2. Kapan sebaiknya menggunakan HashMap? Jawaban: HashMap digunakan ketika kita perlu menyimpan data dalam bentuk pasangan kunci-nilai (Key-Value) dan membutuhkan performa cepat untuk mencari data berdasarkan kuncinya.

3. Jelaskan fungsi method put pada HashMap! Jawaban: Method put(key, value) digunakan untuk menambahkan pasangan data baru ke dalam map, atau memperbarui nilai (value) jika kunci (key) tersebut sudah ada sebelumnya.