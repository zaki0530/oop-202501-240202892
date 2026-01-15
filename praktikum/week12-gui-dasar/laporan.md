# Laporan Praktikum Week 12 – GUI Dasar JavaFX

## Identitas
- **Nama** : Abu Zaki
- **NIM** : 240202892
- **Kelas** : OOP

---

## A. Tujuan Pembelajaran
1. Menjelaskan konsep *Event-Driven Programming*.
2. Membangun antarmuka grafis (GUI) sederhana menggunakan JavaFX.
3. Mengintegrasikan GUI dengan backend (DAO & Service) menggunakan pola MVC.

---

## Dasar Teori
1. **JavaFX**: Platform perangkat lunak untuk membuat aplikasi desktop modern dengan antarmuka pengguna grafis (GUI) di Java.
2. **Event-Driven Programming**: Paradigma pemrograman di mana alur program ditentukan oleh peristiwa (*event*) seperti klik tombol, input keyboard, atau gerakan mouse.
3. **MVC (Model-View-Controller)**: Pola desain yang memisahkan aplikasi menjadi tiga komponen:
   - **Model**: Data (Product).
   - **View**: Tampilan antarmuka (Form Input).
   - **Controller**: Logika yang menghubungkan View dan Model.

---

## Langkah Praktikum
1. **Setup Library**: Menambahkan library JavaFX SDK ke dalam *Referenced Libraries* di VS Code.
2. **Struktur Project**: Membuat paket baru `view`, `controller`, dan `service` untuk menerapkan arsitektur MVC.
3. **Coding Service**: Membuat `ProductService` sebagai jembatan logika antara Controller dan DAO.
4. **Coding GUI**: Membuat `ProductFormView` berisi TextField dan Button, serta `ProductController` untuk menangani aksi tombol.
5. **Launcher**: Membuat class `Launcher.java` untuk mengatasi error modul JavaFX pada JDK versi baru.
6. **Testing**: Menjalankan aplikasi dan memastikan data tersimpan ke database MySQL (XAMPP).

---

## Kode Program
ProductController.java
package com.upb.agripos.controller;

import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductFormView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ProductController {

    private ProductFormView view;
    private ProductService service;

    public ProductController(ProductFormView view) {
        this.view = view;
        this.service = new ProductService(); // Panggil service yang konek ke DB

        // Pasang "Telinga" di tombol Simpan
        this.view.getBtnSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                simpanProduk();
            }
        });
    }

    private void simpanProduk() {
        try {
            // 1. Ambil data dari View
            String code = view.getCode();
            String name = view.getName();
            
            // Validasi sederhana
            if (code.isEmpty() || name.isEmpty()) {
                view.appendLog("Error: Kode dan Nama tidak boleh kosong!");
                return;
            }

            double price = Double.parseDouble(view.getPrice());
            int stock = Integer.parseInt(view.getStock());

            // 2. Kirim ke Service -> Database
            service.addProduct(code, name, price, stock);

            // 3. Beri kabar ke View
            view.appendLog("Sukses: Data " + name + " berhasil disimpan!");
            view.clearForm();

        } catch (NumberFormatException e) {
            view.appendLog("Error: Harga dan Stok harus angka!");
        } catch (Exception e) {
            view.appendLog("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
## Hasil Eksekusi
![alt text](<Screenshot (162).png>) ![alt text](<Screenshot (160).png>)

## Analisis
1. Pola MVC: Dengan memisahkan View (tampilan) dari Controller (logika), kode menjadi lebih rapi. Jika ingin mengubah desain tombol, kita cukup edit file View tanpa mengganggu logika penyimpanan data.

2. JavaFX Launcher: Karena menggunakan JDK versi terbaru, menjalankan class turunan Application secara langsung sering menyebabkan error NoClassDefFoundError. Solusinya adalah membuat class Launcher terpisah untuk memanggil main().

3. Integrasi Database: GUI ini tidak memiliki kode SQL sama sekali. Ia hanya memanggil Service, dan Service memanggil DAO. Ini sesuai dengan prinsip Separation of Concerns.

## Artefak Bab 6,Referensi,Handler GUI,Controller/Service,DAO,Dampak UI/DB
Use Case,UC-01 Tambah Produk,"Tombol ""Simpan Produk""",ProductController.simpanProduk() → ProductService.addProduct(),ProductDAO.insert(),Data baru muncul di tabel database & Log sukses di layar
Activity,AD-01 Input Data,Form Input TextFields,Validasi input kosong & tipe data angka,-,Menampilkan pesan error jika input salah
Sequence,SD-01 Simpan Data,btnSave.setOnAction,View memanggil Controller → Controller memanggil Service,DAO eksekusi SQL,Urutan pemanggilan objek sesuai diagram sekuens

## Kesimpulan
Pembuatan aplikasi GUI dengan JavaFX memberikan pengalaman interaktif bagi pengguna dibandingkan CLI. Penerapan arsitektur MVC sangat penting dalam pengembangan aplikasi GUI agar kode mudah dirawat (maintainable) dan diuji. Integrasi antara GUI (Frontend) dan DAO (Backend) berhasil dilakukan melalui layer Service.