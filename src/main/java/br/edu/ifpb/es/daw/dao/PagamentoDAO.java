package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Pagamento;

public interface PagamentoDAO extends DAO<Pagamento, Long> {
    Pagamento findByStatus(boolean status) throws PersistenciaDawException;
}
