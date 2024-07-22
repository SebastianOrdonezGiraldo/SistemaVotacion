package com.example.sistemavotacion.Controller;

import com.example.sistemavotacion.Model.Candidate;
import com.example.sistemavotacion.Model.CandidateDAO;
import com.example.sistemavotacion.Model.Vote;
import com.example.sistemavotacion.Model.VoteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDateTime;

public class RegisterVoteController {

    @FXML
    private ComboBox<Candidate> candidateComboBox;

    @FXML
    public void initialize() {
        CandidateDAO candidateDAO = new CandidateDAO();
        candidateComboBox.getItems().addAll(candidateDAO.getCandidates());
    }

    @FXML
    private void handleRegister() {
        Candidate selectedCandidate = candidateComboBox.getSelectionModel().getSelectedItem();

        if (selectedCandidate == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione un candidato.");
            alert.showAndWait();
            return;
        }

        VoteDAO voteDAO = new VoteDAO();
        // Aquí debes obtener el ID del votante de alguna manera, por ejemplo, desde una sesión o una entrada de usuario
        int voterId = 1; // Ejemplo: ID del votante
        Vote vote = new Vote(selectedCandidate.getId(), voterId, LocalDateTime.now());

        try {
            voteDAO.registerVote(vote);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Voto registrado con éxito.");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al registrar el voto.");
            alert.showAndWait();
        }
    }
}
