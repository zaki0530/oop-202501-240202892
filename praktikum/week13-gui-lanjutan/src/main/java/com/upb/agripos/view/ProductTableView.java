package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductTableView extends VBox {
    
    // Form Input
    private TextField txtCode = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtStock = new TextField();
    private Button btnSave = new Button("Tambah");
    private Button btnDelete = new Button("Hapus");

    // Tabel
    private TableView<Product> table = new TableView<>();

    public ProductTableView() {
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        // 1. Setup Kolom Tabel
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);

        // 2. Setup Form Input (Dibuat Baris/Horizontal biar rapi)
        txtCode.setPromptText("Kode");
        txtName.setPromptText("Nama Produk");
        txtPrice.setPromptText("Harga");
        txtStock.setPromptText("Stok");

        HBox formLayout = new HBox(10, txtCode, txtName, txtPrice, txtStock, btnSave, btnDelete);
        
        // 3. Gabungkan Semua
        this.getChildren().addAll(
            new Label("Daftar Produk (Database)"),
            table,
            new Label("Kelola Produk:"),
            formLayout
        );
    }

    // Getter
    public TextField getTxtCode() { return txtCode; }
    public TextField getTxtName() { return txtName; }
    public TextField getTxtPrice() { return txtPrice; }
    public TextField getTxtStock() { return txtStock; }
    public Button getBtnSave() { return btnSave; }
    public Button getBtnDelete() { return btnDelete; }
    public TableView<Product> getTable() { return table; }
    
    public void clearForm() {
        txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
    }
}