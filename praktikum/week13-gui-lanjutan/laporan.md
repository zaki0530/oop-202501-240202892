# Laporan Praktikum Week 13 – GUI Lanjutan (TableView & Lambda)

## Identitas
- **Nama** : Abu Zaki
- **NIM** : 240202892
- **Kelas** : OOP

---

## A. Tujuan Pembelajaran
1. Menampilkan data database menggunakan komponen `TableView` JavaFX.
2. Menerapkan *Lambda Expression* untuk memeperingkas penulisan event handler.
3. Mengintegrasikan fitur CRUD (Create, Read, Delete) secara penuh antara GUI dan DAO.

---

## Dasar Teori
1. **TableView**: Komponen JavaFX yang digunakan untuk menampilkan data dalam format baris dan kolom. TableView membutuhkan `ObservableList` agar setiap perubahan data (tambah/hapus) otomatis terlihat di layar tanpa refresh manual yang rumit.
2. **Lambda Expression**: Fitur Java (sejak Java 8) yang memungkinkan penulisan kode fungsi anonim menjadi sangat ringkas. Contohnya `event -> action()` menggantikan penulisan `new EventHandler...`.
3. **Data Binding**: Proses menghubungkan kolom tabel dengan properti pada class Model (`Product`), sehingga tabel tahu data mana yang harus ditampilkan di kolom "Harga", "Nama", dll.

---

## Langkah Praktikum
1. **Setup Project**: Melanjutkan struktur MVC dari Week 12 dan menambahkan library JavaFX.
2. **Update Service**: Menambahkan metode `findAll()` dan `deleteProduct()` pada `ProductService` untuk mendukung kebutuhan tabel.
3. **Desain GUI**: Mengganti `ProductFormView` menjadi `ProductTableView` yang memuat tabel data dan form input secara bersamaan.
4. **Controller Logic**: 
   - Menggunakan `FXCollections.observableArrayList` untuk menampung data dari database.
   - Menggunakan Lambda Expression pada tombol "Simpan" dan "Hapus".
5. **Testing**: Memastikan data lama muncul, data baru bisa ditambahkan, dan data terpilih bisa dihapus.

---

## Kode Program Utama

**1. Implementasi Lambda Expression (ProductController.java)**
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ProductController {
    
    private ProductTableView view;
    private ProductService service;

    public ProductController(ProductTableView view) {
        this.view = view;
        this.service = new ProductService();

        // Load data awal saat aplikasi dibuka
        loadData();

        // Event Tombol Simpan (Lambda Expression)
        this.view.getBtnSave().setOnAction(e -> simpanProduk());

        // Event Tombol Hapus (Lambda Expression)
        this.view.getBtnDelete().setOnAction(e -> hapusProduk());
    }

    private void loadData() {
        // Ambil data dari DB, ubah jadi ObservableList agar TableView mengerti
        ObservableList<Product> data = FXCollections.observableArrayList(service.findAll());
        view.getTable().setItems(data);
    }

    private void simpanProduk() {
        try {
            String code = view.getTxtCode().getText();
            String name = view.getTxtName().getText();
            double price = Double.parseDouble(view.getTxtPrice().getText());
            int stock = Integer.parseInt(view.getTxtStock().getText());

            service.addProduct(code, name, price, stock);
            view.clearForm();
            loadData(); // Refresh tabel

        } catch (Exception e) {
            showAlert("Error Input", "Pastikan harga/stok berupa angka.");
        }
    }

    private void hapusProduk() {
        // Ambil item yang sedang dipilih di tabel
        Product selected = view.getTable().getSelectionModel().getSelectedItem();
        
        if (selected != null) {
            service.deleteProduct(selected.getCode());
            loadData(); // Refresh tabel
        } else {
            showAlert("Peringatan", "Pilih produk di tabel dulu untuk dihapus!");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

## Load Data ke Tabel (ProductController.java)
private void loadData() {
    // Mengambil List dari DAO, dibungkus jadi ObservableList
    ObservableList<Product> data = FXCollections.observableArrayList(service.findAll());
    // Masukkan ke tabel
    view.getTable().setItems(data);
}

## Setup Kolom Tabel (ProductTableView.java)
TableColumn<Product, String> colName = new TableColumn<>("Nama");
// Menghubungkan kolom dengan field "name" di class Product
colName.setCellValueFactory(new PropertyValueFactory<>("name"));

## Hasil Eksekusi
![alt text](<Screenshot (168).png>)![alt text](<Screenshot (167).png>)

## Artefak Bab 6
Referensi,Handler GUI,Controller/Service,DAO,Dampak UI/DB
Use Case,UC-02 Lihat Daftar,Saat Aplikasi Dibuka,Controller.loadData() → Service.findAll(),DAO.findAll() (SELECT *),Tabel otomatis terisi data dari DB
Use Case,UC-03 Hapus Produk,"Tombol ""Hapus""",btnDelete.setOnAction(e -> ...),DAO.delete(code),Data hilang dari DB & Tabel me-refresh diri
Sequence,SD-02 Hapus Data,Klik Baris -> Tombol Hapus,View mengambil item terpilih → Controller panggil Service,Eksekusi Query DELETE,Urutan validasi dan eksekusi sesuai diagram

## Kesimpulan
Penggunaan TableView membuat tampilan data jauh lebih informatif dibandingkan sekadar log teks. Integrasi ObservableList dengan DAO memungkinkan aplikasi bersifat responsif; saat data dihapus di database, tampilan tabel langsung menyesuaikan diri. Penggunaan Lambda Expression juga berhasil mengurangi jumlah baris kode (boilerplate) secara signifikan di bagian Controller.