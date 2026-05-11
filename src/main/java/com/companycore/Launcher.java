package com.companycore;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("auth/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setTitle("Login");
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("--- DEBUG DATENBANK ---");
        System.out.println("URL:  " + System.getenv("DB_URL"));
        System.out.println("USER: " + System.getenv("DB_USER"));
        System.out.println("-----------------------");

        Application.launch(Launcher.class, args);
    }
}
