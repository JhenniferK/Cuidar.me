package br.edu.ifpb.es.bd.dao;

import br.edu.ifpb.es.bd.entities.Paciente;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PacienteDAO {
    Paciente salvarPaciente(Paciente paciente) throws SQLException;
    Optional<Paciente> buscarPaciente(Long cpf) throws SQLException;
    List<Paciente> listarPaciente() throws SQLException;
    boolean editarPaciente(Paciente paciente) throws SQLException;
    boolean removerPaciente(Long cpf) throws SQLException;
}
