package com.companycore.auth.controller;

import com.companycore.database.connection.DatabaseConnection;
import com.companycore.database.dao.employee.EmployeeDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    @FXML private TextField tfUsername;
    @FXML private TextField pfPassword;
    @FXML private Hyperlink hlForgotPassword;
    @FXML private Button btnLogin;

    private EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

    @FXML
    private void initialize() {
        btnLogin.setOnAction(e -> login());
    }

    private void login() {
        String username = tfUsername.getText();
        String password = pfPassword.getText();

        boolean success = employeeDao.employeeLogin(username, password);

        if (success) {
            Stage btnStage = (Stage) btnLogin.getScene().getWindow();
            btnStage.close();
            openMainMenu();
        } else {
            loginFailedPopup();
        }
    }

    private void openMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/companycore/features/main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(loader.load());

            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loginFailedPopup() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Login failed \nUsername or Password wrong");
        alert.setContentText("Please try logging in again.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        dialogPane.getStyleClass().add("login-failed-alert");

        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.initStyle(StageStyle.TRANSPARENT);
        dialogPane.getScene().setFill(Color.TRANSPARENT);

        alert.setOnShowing(e -> {
            double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();

            stage.setX((screenWidth - dialogPane.getWidth()) / 2);
            stage.setY(275);
        });

        alert.showAndWait();
    }
}
