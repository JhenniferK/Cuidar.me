package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProntuarioDAO;
import br.edu.ifpb.es.daw.dao.impl.ProntuarioDAOImpl;
import br.edu.ifpb.es.daw.entities.Prontuario;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;

public class MainProntuarioSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            ProntuarioDAO prontuarioDAO = new ProntuarioDAOImpl(emf);
            Prontuario prontuario = new Prontuario();

            prontuario.setDescricao("A paciente Joyce está enfrentando problemas com ansiedade");
            LocalDateTime localDateTime = LocalDateTime.of(2025, 4, 3, 14, 30);
            prontuario.setDataRegistro(localDateTime);

            System.out.println(prontuario);
            prontuarioDAO.save(prontuario);
            System.out.println(prontuario);

        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }
    }
}
