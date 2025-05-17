package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Prontuario;

public interface ProntuarioDAO extends DAO<Prontuario, Long> {
    Prontuario findById(Long id) throws PersistenciaDawException;
    Prontuario deleteById(Long id) throws PersistenciaDawException;
}
