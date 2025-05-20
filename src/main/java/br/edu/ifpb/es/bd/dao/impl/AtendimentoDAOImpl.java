package br.edu.ifpb.es.bd.dao.impl;

import br.edu.ifpb.es.bd.dao.AtendimentoDAO;
import br.edu.ifpb.es.bd.dao.DataBaseConnection;
import br.edu.ifpb.es.bd.entities.Atendimento;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AtendimentoDAOImpl implements AtendimentoDAO {
    public Atendimento salvarAtendimento(Atendimento atendimento) throws SQLException {
        String query = "INSERT INTO atendimento (data, localidade, agendado) VALUES (?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(atendimento.getData())); // Converte LocalDateTime para Timestamp
            preparedStatement.setString(2, atendimento.getLocalidade());
            preparedStatement.setBoolean(3, atendimento.getAgendado());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar atendimento!!");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    atendimento.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao salvar atendimento, nenhum ID obtido!");
                }
            }
        }
        return atendimento;
    }
    public Optional<Atendimento> buscarAtendimento(LocalDateTime data) throws SQLException {
        Atendimento atendimento = null;
        String query = "SELECT id, data, localidade, agendado FROM atendimento WHERE data = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(data)); // Converte LocalDateTime para Timestamp
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    atendimento = mapResultSetToAtendimento(rs);
                }
            }
        }
        return Optional.ofNullable(atendimento);
    }
    public List<Atendimento> listarAtendimento() throws SQLException {
        List<Atendimento> atendimentos = new ArrayList<>();
        String query = "SELECT id, data, localidade, agendado FROM atendimento ORDER BY data";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                atendimentos.add(mapResultSetToAtendimento(rs));
            }
        }
        return atendimentos;
    }
    public Atendimento editarAtendimento(Atendimento atendimento) throws SQLException {
        if (atendimento.getId() == null) {
            throw new SQLException("ID do atendimento não pode ser nulo para edição.");
        }
        String query = "UPDATE atendimento SET data = ?, localidade = ?, agendado = ? WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(atendimento.getData())); // Converte LocalDateTime para Timestamp
            preparedStatement.setString(2, atendimento.getLocalidade());
            preparedStatement.setBoolean(3, atendimento.getAgendado());
            preparedStatement.setLong(4, atendimento.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao editar atendimento, nenhum registro foi atualizado.");
            }
            return atendimento;
        }
    }
    public Atendimento removerAtendimento(Atendimento atendimento) throws SQLException {
        String query = "DELETE FROM atendimento WHERE id = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, atendimento.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao remover atendimento, nenhum registro foi encontrado.");
            }
            return atendimento;
        }
    }
    private Atendimento mapResultSetToAtendimento(ResultSet rs) throws SQLException {
        return new Atendimento(
                rs.getLong("id"),
                rs.getTimestamp("data").toLocalDateTime(), // Converte Timestamp para LocalDateTime
                rs.getString("localidade"),
                rs.getBoolean("agendado")
        );
    }
}
