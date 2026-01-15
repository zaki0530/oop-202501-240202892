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