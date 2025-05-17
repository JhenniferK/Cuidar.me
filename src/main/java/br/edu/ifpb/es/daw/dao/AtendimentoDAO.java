package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Atendimento;

import java.util.Date;

public interface AtendimentoDAO extends DAO<Atendimento, Long> {
    Atendimento findByData(Date data) throws PersistenciaDawException;
}
