package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.ProntuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.ProntuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Prontuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainProntuarioDeleteAll {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProntuarioDAO prontuarioDAO = new ProntuarioDAOImpl(emf);
            List<Prontuario> prontuarios = prontuarioDAO.getAll();
            for(Prontuario prontuario : prontuarios){
                prontuarioDAO.delete(prontuario.getId());
            }
        }
    }
}
