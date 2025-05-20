package br.edu.ifpb.es.bd.dao;

import br.edu.ifpb.es.bd.entities.Atendimento;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AtendimentoDAO {
    Atendimento salvarAtendimento(Atendimento atendimento) throws SQLException;
    Optional<Atendimento> buscarAtendimento(LocalDateTime data) throws SQLException;
    List<Atendimento> listarAtendimento() throws SQLException;
    Atendimento removerAtendimento(Atendimento atendimento) throws SQLException;
    Atendimento editarAtendimento(Atendimento atendimento) throws SQLException;

}
