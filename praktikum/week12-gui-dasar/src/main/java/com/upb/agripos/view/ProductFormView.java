package com.upb.agripos.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

// View mewarisi VBox agar otomatis jadi layout vertikal
public class ProductFormView extends VBox {

    // Komponen GUI kita jadikan public/memiliki getter agar bisa diakses Controller
    private TextField txtCode = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtStock = new TextField();
    private Button btnSave = new Button("Simpan Produk");
    private TextArea txtResult = new TextArea();

    public ProductFormView() {
        // 1. Setup Layout
        this.setPadding(new Insets(20));
        this.setSpacing(10); // Jarak antar elemen

        // 2. Setup Komponen
        txtCode.setPromptText("Contoh: P01");
        txtName.setPromptText("Contoh: Bibit Jagung");
        txtResult.setPrefHeight(100);
        txtResult.setEditable(false);

        // 3. Masukkan semua ke dalam layar
        this.getChildren().addAll(
            new Label("Kode Produk:"), txtCode,
            new Label("Nama Produk:"), txtName,
            new Label("Harga:"), txtPrice,
            new Label("Stok:"), txtStock,
            btnSave,
            new Label("Log Status:"), txtResult
        );
    }

    // --- Getter untuk mengambil data inputan ---
    public String getCode() { return txtCode.getText(); }
    public String getName() { return txtName.getText(); }
    public String getPrice() { return txtPrice.getText(); }
    public String getStock() { return txtStock.getText(); }
    public Button getBtnSave() { return btnSave; }

    // --- Method untuk menampilkan pesan di layar ---
    public void appendLog(String message) {
        txtResult.appendText(message + "\n");
    }
    
    // --- Method untuk membersihkan form ---
    public void clearForm() {
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }
}