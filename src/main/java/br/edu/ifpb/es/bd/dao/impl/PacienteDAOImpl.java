package br.edu.ifpb.es.bd.dao.impl;

import br.edu.ifpb.es.bd.dao.DataBaseConnection;
import br.edu.ifpb.es.bd.dao.PacienteDAO;
import br.edu.ifpb.es.bd.entities.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteDAOImpl implements PacienteDAO {
    public Paciente salvarPaciente(Paciente paciente) throws SQLException {
        String query = "INSERT INTO paciente (cpf, rg, info_adicionais)VALUES (?,?,?)";
        try (Connection connection = DataBaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, paciente.getCpf());
            preparedStatement.setLong(2, paciente.getRg());
            preparedStatement.setString(3, paciente.getInfo_adicionais());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar paciente!!");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    paciente.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao salvar paciente, nenhum ID obtido!");
                }
            }
        }
        return paciente;
    }
    public Optional<Paciente> buscarPaciente(Long cpf) throws SQLException {
        Paciente paciente = null;
        String query = "SELECT id, cpf, rg, info_adicionais FROM paciente WHERE cpf = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, cpf);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    paciente = mapResultSetToPaciente(rs);
                }
            }
        }
        return Optional.ofNullable(paciente);
    }

    public List<Paciente> listarPaciente() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT id, cpf, rg, info_adicionais FROM paciente ORDER BY cpf";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                pacientes.add(mapResultSetToPaciente(rs));
            }
        }
        return pacientes;
    }
    public boolean editarPaciente(Paciente paciente) throws SQLException {
        if (paciente.getId() == null) {
            throw new SQLException("ID do paciente não pode ser nulo para edição.");
        }
        String query = "UPDATE paciente SET rg = ?, info_adicionais = ? WHERE cpf = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, paciente.getRg());
            preparedStatement.setString(2, paciente.getInfo_adicionais());
            preparedStatement.setLong(3, paciente.getCpf());
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean removerPaciente(Long cpf) throws SQLException {
        String query = "DELETE FROM paciente WHERE cpf = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, cpf);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows > 0;
        }
    }
    private Paciente mapResultSetToPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente(
                rs.getLong("id"),
                rs.getLong("cpf"),
                null, // Aqui você deve mapear o contato de emergência se necessário
                rs.getLong("rg"),
                null, // Aqui você deve mapear o endereço pessoal se necessário
                null, // Aqui você deve mapear o endereço de trabalho se necessário
                rs.getString("info_adicionais")
        );
        return paciente;
    }
}
