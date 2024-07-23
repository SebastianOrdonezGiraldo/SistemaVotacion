package com.example.sistemavotacion.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdminController {
    @FXML private TextField candidateNameField;
    @FXML private TextField candidatePartyField;
    @FXML private Label candidateMessage;

    @FXML private TextField voterNameField;
    @FXML private TextField voterIdField;
    @FXML private Label voterMessage;

    @FXML private TableView<CandidateResult> resultsTable;
    @FXML private TableColumn<CandidateResult, String> candidateColumn;
    @FXML private TableColumn<CandidateResult, Integer> votesColumn;

    private ObservableList<CandidateResult> candidateResults = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Inicializar las columnas de la tabla
        candidateColumn.setCellValueFactory(new PropertyValueFactory<>("candidateName"));
        votesColumn.setCellValueFactory(new PropertyValueFactory<>("votes"));

        // Vincular la lista observable a la tabla
        resultsTable.setItems(candidateResults);
    }

    @FXML
    public void handleAddCandidate() {
        String name = candidateNameField.getText();
        String party = candidatePartyField.getText();
        if (name.isEmpty() || party.isEmpty()) {
            candidateMessage.setText("Por favor, complete todos los campos.");
            return;
        }
        // Aquí iría la lógica para agregar el candidato a la base de datos
        candidateMessage.setText("Candidato agregado: " + name + " (" + party + ")");
        candidateNameField.clear();
        candidatePartyField.clear();
    }

    @FXML
    public void handleAddVoter() {
        String name = voterNameField.getText();
        String id = voterIdField.getText();
        if (name.isEmpty() || id.isEmpty()) {
            voterMessage.setText("Por favor, complete todos los campos.");
            return;
        }
        // Aquí iría la lógica para agregar el votante a la base de datos
        voterMessage.setText("Votante agregado: " + name + " (ID: " + id + ")");
        voterNameField.clear();
        voterIdField.clear();
    }

    @FXML
    public void handleUpdateResults() {
        // Aquí iría la lógica para obtener los resultados actualizados de la base de datos
        // Por ahora, solo agregaremos algunos datos de ejemplo
        candidateResults.clear();
        candidateResults.addAll(
                new CandidateResult("Candidato 1", 100),
                new CandidateResult("Candidato 2", 85),
                new CandidateResult("Candidato 3", 120)
        );
    }

    // Clase interna para representar los resultados de los candidatos
    public static class CandidateResult {
        private final String candidateName;
        private final int votes;

        public CandidateResult(String candidateName, int votes) {
            this.candidateName = candidateName;
            this.votes = votes;
        }

        public String getCandidateName() { return candidateName; }
        public int getVotes() { return votes; }
    }
}