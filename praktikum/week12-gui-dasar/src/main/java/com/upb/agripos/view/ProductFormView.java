package com.upb.agripos;

// --- BAGIAN IMPORT INI SANGAT PENTING ---
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.view.ProductFormView;
// ----------------------------------------

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductFormView extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // 1. Panggil View (Tampilan)
            ProductFormView view = new ProductFormView();

            // 2. Panggil Controller (Otak)
            new ProductController(view);

            // 3. Tampilkan Jendela
            Scene scene = new Scene(view, 400, 500);
            stage.setTitle("Agri-POS (Week 12 - MVC Pattern)");
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace(); // Tampilkan error di terminal jika ada masalah
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}