package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.service.ValidationException;
import com.upb.agripos.view.PosView;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

public class PosController {
    private PosView view;
    private ProductService productService;
    private CartService cartService;

    public PosController(PosView view) {
        this.view = view;
        this.productService = new ProductService();
        this.cartService = new CartService();

        initController();
    }

    private void initController() {
        // Tampilkan Identitas (Syarat Bab 14)
        System.out.println("Hello World, I am Abu Zaki - 240202892");

        loadProducts();

        // Event Handlers
        view.getBtnSave().setOnAction(e -> saveProduct());
        view.getBtnDelete().setOnAction(e -> deleteProduct());
        view.getBtnAddToCart().setOnAction(e -> addToCart());
        view.getBtnCheckout().setOnAction(e -> {
            cartService.clearCart();
            refreshCart();
            showAlert("Sukses", "Transaksi berhasil!");
        });
    }

    private void loadProducts() {
        view.getTableProduct().setItems(FXCollections.observableArrayList(productService.findAll()));
    }

    private void saveProduct() {
        try {
            productService.addProduct(
                view.getTxtCode().getText(),
                view.getTxtName().getText(),
                Double.parseDouble(view.getTxtPrice().getText()),
                Integer.parseInt(view.getTxtStock().getText())
            );
            view.clearInput();
            loadProducts();
        } catch (NumberFormatException e) {
            showAlert("Error", "Harga/Stok harus angka!");
        } catch (ValidationException e) {
            showAlert("Validasi", e.getMessage());
        }
    }

    private void deleteProduct() {
        Product p = view.getTableProduct().getSelectionModel().getSelectedItem();
        if (p != null) {
            productService.deleteProduct(p.getCode());
            loadProducts();
        }
    }

    private void addToCart() {
        try {
            Product p = view.getTableProduct().getSelectionModel().getSelectedItem();
            if (p == null) throw new ValidationException("Pilih produk dulu!");
            
            int qty = Integer.parseInt(view.getTxtQty().getText());
            cartService.addItem(p, qty);
            refreshCart();
        } catch (NumberFormatException e) {
            showAlert("Error", "Qty harus angka!");
        } catch (ValidationException e) {
            showAlert("Gagal", e.getMessage());
        }
    }

    private void refreshCart() {
        view.getTableCart().setItems(FXCollections.observableArrayList(cartService.getItems()));
        view.getLblTotal().setText("Total: Rp " + cartService.getTotal());
    }

    private void showAlert(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title); a.setContentText(msg); a.showAndWait();
    }
}