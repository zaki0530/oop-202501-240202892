package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import com.upb.agripos.model.CartItem;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PosView extends HBox {
    // Kiri: Produk
    private TextField txtCode = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtStock = new TextField();
    private Button btnSave = new Button("Tambah Produk");
    private Button btnDelete = new Button("Hapus");
    private TableView<Product> tableProduct = new TableView<>();

    // Kanan: Keranjang
    private TextField txtQty = new TextField();
    private Button btnAddToCart = new Button("Masuk Keranjang ->");
    private TableView<CartItem> tableCart = new TableView<>();
    private Label lblTotal = new Label("Total: Rp 0");
    private Button btnCheckout = new Button("Bayar / Reset");

    public PosView() {
        this.setPadding(new Insets(15));
        this.setSpacing(20);

        // --- SETUP KIRI (Produk) ---
        VBox left = new VBox(10);
        left.setPrefWidth(400);

        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableProduct.getColumns().addAll(colCode, colName, colPrice, colStock);
        
        txtCode.setPromptText("Kode"); txtName.setPromptText("Nama");
        txtPrice.setPromptText("Harga"); txtStock.setPromptText("Stok");

        left.getChildren().addAll(new Label("Database Produk"), tableProduct, 
            new HBox(5, txtCode, txtName), new HBox(5, txtPrice, txtStock), 
            new HBox(5, btnSave, btnDelete));

        // --- SETUP KANAN (Keranjang) ---
        VBox right = new VBox(10);
        right.setPrefWidth(350);

        TableColumn<CartItem, String> cName = new TableColumn<>("Item");
        cName.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getProduct().getName()));
        TableColumn<CartItem, Integer> cQty = new TableColumn<>("Qty");
        cQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TableColumn<CartItem, Double> cSub = new TableColumn<>("Subtotal");
        cSub.setCellValueFactory(new PropertyValueFactory<>("subtotal"));

        tableCart.getColumns().addAll(cName, cQty, cSub);
        txtQty.setPromptText("Jumlah Beli");
        lblTotal.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        right.getChildren().addAll(new Label("Keranjang Belanja"), 
            new HBox(5, txtQty, btnAddToCart), tableCart, lblTotal, btnCheckout);

        this.getChildren().addAll(left, right);
    }

    // Getters
    public TextField getTxtCode() { return txtCode; }
    public TextField getTxtName() { return txtName; }
    public TextField getTxtPrice() { return txtPrice; }
    public TextField getTxtStock() { return txtStock; }
    public TextField getTxtQty() { return txtQty; }
    public Button getBtnSave() { return btnSave; }
    public Button getBtnDelete() { return btnDelete; }
    public Button getBtnAddToCart() { return btnAddToCart; }
    public Button getBtnCheckout() { return btnCheckout; }
    public Label getLblTotal() { return lblTotal; }
    public TableView<Product> getTableProduct() { return tableProduct; }
    public TableView<CartItem> getTableCart() { return tableCart; }
    public void clearInput() { txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear(); }
}