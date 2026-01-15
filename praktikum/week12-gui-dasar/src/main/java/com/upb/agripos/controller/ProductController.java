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