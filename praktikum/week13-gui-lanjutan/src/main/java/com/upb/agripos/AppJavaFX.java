package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Gunakan View yang baru (Tabel)
            ProductTableView view = new ProductTableView();
            
            // Hubungkan Controller
            new ProductController(view);

            Scene scene = new Scene(view, 600, 400); // Ukuran lebih lebar
            stage.setTitle("Agri-POS (Week 13 - TableView & CRUD)");
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}