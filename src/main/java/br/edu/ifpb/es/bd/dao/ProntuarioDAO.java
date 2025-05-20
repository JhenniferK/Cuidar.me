package br.edu.ifpb.es.bd.dao;

import br.edu.ifpb.es.bd.entities.Prontuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProntuarioDAO {
    Prontuario salvarProntuario(Prontuario prontuario) throws SQLException;
    Optional<Prontuario> buscarProntuario(Long id) throws SQLException;
    List<Prontuario> listarProntuario() throws SQLException;
    boolean editarProntuario(Prontuario prontuario) throws SQLException;
    boolean removerProntuario(Long id) throws SQLException;
}