package com.example.sistemavotacion.Model;

import com.example.sistemavotacion.Util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VoteDAO {

    private static final Logger LOGGER = Logger.getLogger(VoteDAO.class.getName());

    public void registerVote(Vote vote) throws SQLException {
        String query = "INSERT INTO votes (candidate_id, voter_id, date) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, vote.getCandidateId());
            preparedStatement.setInt(2, vote.getVoterId());
            preparedStatement.setString(3, vote.getDate().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al registrar el voto", e);
            throw e;
        }
    }

    public List<Vote> getVotes() {
        List<Vote> votes = new ArrayList<>();
        String query = "SELECT * FROM votes";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Vote vote = new Vote(
                        resultSet.getInt("candidate_id"),
                        resultSet.getInt("voter_id"),
                        resultSet.getTimestamp("date").toLocalDateTime()
                );
                votes.add(vote);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener los votos", e);
        }
        return votes;
    }

    public boolean hasVoted(int voterId, int candidateId) {
        String query = "SELECT COUNT(*) FROM votes WHERE voter_id = ? AND candidate_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, voterId);
            preparedStatement.setInt(2, candidateId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al verificar si el votante ya ha votado", e);
        }
        return false;
    }

    // Nuevo método para obtener el conteo de votos para un candidato específico
    public int getVoteCount(int candidateId) {
        String query = "SELECT COUNT(*) FROM votes WHERE candidate_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, candidateId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener el conteo de votos para el candidato con ID: " + candidateId, e);
        }
        return 0; // Retorna 0 si ocurre un error o no hay votos
    }
}
