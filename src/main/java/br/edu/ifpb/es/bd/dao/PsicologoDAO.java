package br.edu.ifpb.es.bd.dao;

import br.edu.ifpb.es.bd.entities.Psicologo;

import java.sql.SQLException;

public interface PsicologoDAO {
    Psicologo salvarPsicologo(Psicologo psicologo) throws SQLException;
}
