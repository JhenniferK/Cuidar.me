package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.PsicologoDAO;
import br.edu.ifpb.es.daw.dao.impl.PsicologoDAOImpl;
import br.edu.ifpb.es.daw.entities.Psicologo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPsicologoSave {
    public static void main(String[] args) throws DawException {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            PsicologoDAO psicologoDAO = new PsicologoDAOImpl(emf);
            Psicologo psicologo = new Psicologo();

            psicologo.setNome("Rennale Gregório");
            psicologo.setEmail("rennaleg@gmail.com");
            psicologo.setSenha("CALYpso");

            System.out.println(psicologo);
            psicologoDAO.save(psicologo);
            System.out.println(psicologo);
        }
    }
}
