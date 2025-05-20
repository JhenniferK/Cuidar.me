package br.edu.ifpb.es.bd.dao.impl;

import br.edu.ifpb.es.bd.dao.DataBaseConnection;
import br.edu.ifpb.es.bd.dao.ProntuarioDAO;
import br.edu.ifpb.es.bd.entities.Prontuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProntuarioDAOImpl implements ProntuarioDAO {
    public Prontuario salvarProntuario(Prontuario prontuario) throws SQLException {
        String query = "INSERT INTO prontuario (descricao, dataRegistro) VALUES (?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, prontuario.getDescricao());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(prontuario.getDataRegistro()));

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar prontuário!!");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    prontuario.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao salvar prontuário, nenhum ID obtido!");
                }
            }
        }
        return prontuario;
    }

    @Override
    public Optional<Prontuario> buscarProntuario(Long id) throws SQLException {
        Prontuario prontuario = null;
        String query = "SELECT id_prontuario, descricao, dataRegistro FROM prontuario WHERE id_prontuario = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    prontuario = mapResultSetToProntuario(rs);
                }
            }
        }
        return Optional.ofNullable(prontuario);
    }

    @Override
    public List<Prontuario> listarProntuario() throws SQLException {
        List<Prontuario> prontuarios = new ArrayList<>();
        String query = "SELECT id_prontuario, descricao, dataRegistro FROM prontuario ORDER BY dataRegistro";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                prontuarios.add(mapResultSetToProntuario(rs));
            }
        }
        return prontuarios;
    }

    @Override
    public boolean editarProntuario(Prontuario prontuario) throws SQLException {
        if (prontuario.getId() == null) {
            throw new SQLException("ID do prontuário não pode ser nulo para edição.");
        }
        String query = "UPDATE prontuario SET descricao = ?, dataRegistro = ? WHERE id_prontuario = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, prontuario.getDescricao());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(prontuario.getDataRegistro()));
            preparedStatement.setLong(3, prontuario.getId());

            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        }
    }

    @Override
    public boolean removerProntuario(Long id) throws SQLException {
        String query = "DELETE FROM prontuario WHERE id_prontuario = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        }
    }

    private Prontuario mapResultSetToProntuario(ResultSet rs) throws SQLException {
        Prontuario prontuario = new Prontuario();
        prontuario.setId(rs.getLong("id_prontuario"));
        prontuario.setDescricao(rs.getString("descricao"));
        prontuario.setDataRegistro(rs.getTimestamp("dataRegistro").toLocalDateTime());
        return prontuario;
    }
}
