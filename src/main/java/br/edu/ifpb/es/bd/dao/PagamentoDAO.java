package br.edu.ifpb.es.bd.dao;

import br.edu.ifpb.es.bd.entities.Pagamento;

import java.sql.SQLException;
import java.util.Optional;

public interface PagamentoDAO {
    Pagamento salvarPagamento(Pagamento pagamento) throws SQLException;
    Optional<Pagamento> buscarPagamento(Long id) throws SQLException;
    Pagamento removerPagamento(Pagamento pagamento) throws SQLException;
}
