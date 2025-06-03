package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.dao.AtendimentoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AtendimentoDAOImpl;
import br.edu.ifpb.es.daw.entities.Atendimento;
import br.edu.ifpb.es.daw.entities.StatusAtendimento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class MainAtendimentoSave {
    public static void main(String[] args) throws PersistenciaDawException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        AtendimentoDAO atendimentoDAO = new AtendimentoDAOImpl(emf);
        Atendimento atendimento = new Atendimento();

        atendimento.setLocalidade("Domicílio");
        LocalDateTime localDateTime = LocalDateTime.of(2025, 4, 3, 14, 30);
        atendimento.setData(localDateTime);

        atendimento.setStatusAtendimento(StatusAtendimento.ATENDIDO);

        System.out.println(atendimento);
        atendimentoDAO.save(atendimento);
        System.out.println(atendimento);
    }
}
