package com.example.sistemavotacion.Controller;

import com.example.sistemavotacion.Model.Vote;
import com.example.sistemavotacion.Model.VoteDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainController {

    @FXML
    private TextField candidateIdField;

    @FXML
    private TextField voterIdField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private void handleRegisterVote() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sistemavotacion/view/register-vote-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Registrar Voto");
            stage.initModality(Modality.APPLICATION_MODAL); // Bloquear eventos en otras ventanas
            stage.setScene(scene);
            stage.showAndWait(); // Mostrar ventana y esperar hasta que se cierre
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores al cargar la vista FXML
            showErrorDialog("Error al cargar la vista de registro de voto.");
        }
    }

    @FXML
    private void handleRegister() {
        try {
            int candidateId = Integer.parseInt(candidateIdField.getText());
            int voterId = Integer.parseInt(voterIdField.getText());
            LocalDate localDate = datePicker.getValue();

            if (localDate == null) {
                showErrorDialog("Por favor, seleccione una fecha.");
                return;
            }

            LocalDateTime localDateTime = localDate.atStartOfDay();

            VoteDAO voteDAO = new VoteDAO();
            if (voteDAO.hasVoted(voterId, candidateId)) {
                showErrorDialog("El votante ya ha votado por este candidato.");
                return;
            }

            Vote vote = new Vote(candidateId, voterId, localDateTime);
            voteDAO.registerVote(vote);

            showSuccessDialog("Voto registrado exitosamente.");

            Stage stage = (Stage) candidateIdField.getScene().getWindow();
            stage.close();
        } catch (NumberFormatException e) {
            showErrorDialog("Por favor, ingrese IDs válidos.");
            e.printStackTrace();
        } catch (Exception e) {
            showErrorDialog("Ocurrió un error al registrar el voto.");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewCandidates() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/sistemavotacion/view/candidates-view.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Ver Candidatos");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            System.err.println("Error al cargar la vista de candidatos: " + e.getMessage());
            e.printStackTrace();
            showErrorDialog("Error al cargar la vista de candidatos.");
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
            showErrorDialog("Error inesperado al abrir la vista de candidatos.");
        }
    }


    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}