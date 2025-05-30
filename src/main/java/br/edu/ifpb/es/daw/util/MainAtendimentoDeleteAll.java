package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.AtendimentoDAO;
import br.edu.ifpb.es.daw.dao.impl.AtendimentoDAOImpl;
import br.edu.ifpb.es.daw.entities.Atendimento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAtendimentoDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){
            AtendimentoDAO atendimentoDAO = new AtendimentoDAOImpl(emf);
            List<Atendimento> atendimentos = atendimentoDAO.getAll();
            for(Atendimento atendimento : atendimentos) {
                atendimentoDAO.delete(atendimento.getId());
            }
        }
    }
}
