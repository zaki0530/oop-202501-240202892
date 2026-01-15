package com.upb.agripos;

import com.upb.agripos.service.ProductService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    // Panggil Service (Logic Backend)
    private ProductService service = new ProductService();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Agri-POS (Week 12 - GUI XAMPP)");

        // 1. Buat Komponen Input (TextField)
        Label lblCode = new Label("Kode Produk:");
        TextField txtCode = new TextField();
        txtCode.setPromptText("Contoh: P02");

        Label lblName = new Label("Nama Produk:");
        TextField txtName = new TextField();
        txtName.setPromptText("Contoh: Pupuk Urea");

        Label lblPrice = new Label("Harga:");
        TextField txtPrice = new TextField();

        Label lblStock = new Label("Stok:");
        TextField txtStock = new TextField();

        // 2. Buat Tombol & Area Hasil
        Button btnSimpan = new Button("Simpan Produk");
        TextArea txtResult = new TextArea();
        txtResult.setPrefHeight(100);
        txtResult.setEditable(false);

        // 3. EVENT HANDLER (Apa yang terjadi saat tombol diklik?)
        btnSimpan.setOnAction(event -> {
            try {
                // Ambil data dari form
                String code = txtCode.getText();
                String name = txtName.getText();
                double price = Double.parseDouble(txtPrice.getText());
                int stock = Integer.parseInt(txtStock.getText());

                // Kirim ke Service -> DAO -> Database XAMPP
                service.addProduct(code, name, price, stock);

                // Tampilkan pesan sukses di layar
                txtResult.appendText("Sukses Input: " + name + "\n");
                
                // Kosongkan form
                txtCode.clear();
                txtName.clear();
                txtPrice.clear();
                txtStock.clear();

            } catch (NumberFormatException e) {
                txtResult.appendText("Error: Harga/Stok harus angka!\n");
            } catch (Exception e) {
                txtResult.appendText("Error: " + e.getMessage() + "\n");
            }
        });

        // 4. Susun Layout (VBox = Vertikal ke bawah)
        VBox layout = new VBox(10); // Jarak antar elemen 10px
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            lblCode, txtCode,
            lblName, txtName,
            lblPrice, txtPrice,
            lblStock, txtStock,
            btnSimpan,
            new Label("Log Aktivitas:"),
            txtResult
        );

        // 5. Tampilkan Scene
        Scene scene = new Scene(layout, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}