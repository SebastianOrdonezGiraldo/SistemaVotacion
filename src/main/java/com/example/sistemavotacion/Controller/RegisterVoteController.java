package com.example.sistemavotacion.Controller;


import com.example.sistemavotacion.Model.Vote;
import com.example.sistemavotacion.Model.VoteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterVoteController {

    @FXML
    private TextField candidateIdField;

    @FXML
    private TextField voterIdField;

    @FXML
    private TextField dateField;

    @FXML
    private void handleRegister() throws SQLException {
        int candidateId = Integer.parseInt(candidateIdField.getText());
        int voterId = Integer.parseInt(voterIdField.getText());
        String dateString = dateField.getText();

        // Convertir la cadena de fecha a LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);

        Vote vote = new Vote(candidateId, voterId, date);
        VoteDAO voteDAO = new VoteDAO();
        voteDAO.registerVote(vote);
    }
}
