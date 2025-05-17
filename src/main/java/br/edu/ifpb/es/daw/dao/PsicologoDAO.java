package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Psicologo;

public interface PsicologoDAO extends DAO<Psicologo, Long> {
    Psicologo findByEmail(String email) throws PersistenciaDawException;
}
