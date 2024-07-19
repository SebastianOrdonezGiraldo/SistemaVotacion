package com.example.sistemavotacion.Model;


import com.example.sistemavotacion.Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    public List<Candidate> getCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        String query = "SELECT * FROM candidates";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Candidate candidate = new Candidate();
                candidate.setId(resultSet.getInt("id"));
                candidate.setName(resultSet.getString("name"));
                candidate.setPhoto(resultSet.getString("photo"));
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}


    // Métodos para insertar, actualizar y eliminar candidatos


