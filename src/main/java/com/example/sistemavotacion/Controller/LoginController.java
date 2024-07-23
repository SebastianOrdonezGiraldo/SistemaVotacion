package com.example.sistemavotacion.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;

    @FXML
    protected void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("votantes".equals(username) && "votantes".equals(password)) {
            try {
                URL resourceUrl = getClass().getResource("/com/example/sistemavotacion/view/hello-view.fxml");
                System.out.println("Resource URL: " + resourceUrl);
                if (resourceUrl == null) {
                    throw new IOException("No se pudo encontrar el archivo FXML");
                }

                FXMLLoader loader = new FXMLLoader(resourceUrl);
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                messageLabel.setText("Error al cargar la nueva ventana: " + e.getMessage());
            }
        } else {
            messageLabel.setText("Usuario o contraseña incorrectos");
        }
    }
}