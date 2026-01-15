package com.upb.agripos;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.view.PosView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage stage) {
        PosView view = new PosView();
        new PosController(view);

        Scene scene = new Scene(view, 800, 500);
        stage.setTitle("Agri-POS Integrasi (Abu Zaki)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}