package br.edu.ifpb.es.bd.dao.impl;

import br.edu.ifpb.es.bd.dao.DataBaseConnection;
import br.edu.ifpb.es.bd.dao.PagamentoDAO;
import br.edu.ifpb.es.bd.entities.Metodo;
import br.edu.ifpb.es.bd.entities.Pagamento;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public abstract class PagamentoDAOImpl implements PagamentoDAO {

    public Pagamento salvarPagamento(Pagamento pagamento) throws SQLException {
        String query = "INSERT INTO pagamento (valor, metodo, status, data) VALUES (?, ?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, pagamento.getValor());
            preparedStatement.setString(2, pagamento.getMetodo().name());
            preparedStatement.setBoolean(3, pagamento.getStatus());

            LocalDateTime data = pagamento.getData();
            preparedStatement.setTimestamp(3, Timestamp.valueOf(data));
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar pagamento!!");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pagamento.setId(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Falha ao salvar pagamento, nenhum ID obtido!");
                }
            }
        }
        return pagamento;
    }
    public Optional<Pagamento> buscarPagamento(Long id) throws SQLException {
        Pagamento pagamento = null;
        String query = "SELECT id_pagamento, valor, metodo, status, data_pagamento FROM pagamento WHERE id_pagamento = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    pagamento = mapResultSetToPagamento(rs);
                }
            }
        }
        return Optional.ofNullable(pagamento);
    }
    public boolean removerPagamento(Long id) throws SQLException {
        String query = "DELETE FROM pagamento WHERE id_pagamento = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        }
    }
    private Pagamento mapResultSetToPagamento(ResultSet rs) throws SQLException {
        Pagamento pagamento = new Pagamento();
        pagamento.setId(rs.getLong("id_pagamento"));
        pagamento.setValor(rs.getInt("valor"));
        pagamento.setMetodo(Metodo.valueOf("metodo"));
        pagamento.setStatus(rs.getBoolean("status"));

        Timestamp timestamp = rs.getTimestamp("data_pagamento");
        pagamento.setData(timestamp.toLocalDateTime());
        return pagamento;
    }
}
