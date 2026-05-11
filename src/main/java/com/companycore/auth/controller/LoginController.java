package com.companycore.auth.controller;

import com.companycore.database.connection.DatabaseConnection;
import com.companycore.database.dao.employee.EmployeeDaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

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

        employeeDao.employeeLogin(username, password);
    }
}
