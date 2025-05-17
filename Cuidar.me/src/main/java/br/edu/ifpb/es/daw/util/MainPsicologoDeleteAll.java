package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.PsicologoDAO;
import br.edu.ifpb.es.daw.dao.impl.PsicologoDAOImpl;
import br.edu.ifpb.es.daw.entities.Psicologo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPsicologoDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            PsicologoDAO psicologoDAO = new PsicologoDAOImpl(emf);
            List<Psicologo> psicologos = psicologoDAO.getAll();
            for(Psicologo psicologo : psicologos){
                psicologoDAO.delete(psicologo.getCrp());
            }
        }
    }
}

