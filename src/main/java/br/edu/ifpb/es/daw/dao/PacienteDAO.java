package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Paciente;

public interface PacienteDAO extends DAO<Paciente, Long> {
    Paciente findByCPF(Long cpf) throws PersistenciaDawException;
}
