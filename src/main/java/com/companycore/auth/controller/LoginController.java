package com.companycore.auth.controller;

import com.companycore.database.connection.DatabaseConnection;
import com.companycore.database.dao.employee.EmployeeDaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
}
