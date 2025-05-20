package br.edu.ifpb.es.bd.dao.impl;

import br.edu.ifpb.es.bd.dao.DataBaseConnection;
import br.edu.ifpb.es.bd.dao.PsicologoDAO;
import br.edu.ifpb.es.bd.entities.Psicologo;

import java.sql.*;

public class PsicologoDAOImpl implements PsicologoDAO {
    public Psicologo salvarPsicologo(Psicologo psicologo) throws SQLException {
        String query = "INSERT INTO psicologo (crp, nome, email, senha) VALUES (?, ?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, psicologo.getCrp());
            preparedStatement.setString(2, psicologo.getNome());
            preparedStatement.setString(3, psicologo.getEmail());
            preparedStatement.setString(4, psicologo.getSenha());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar psicólogo!!");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    psicologo.setCrp(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao salvas psicólogo, nenhum ID obtido!");
                }
            }
        }
        return psicologo;
    }
}