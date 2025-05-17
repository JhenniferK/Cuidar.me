package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AtendimentoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.Atendimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.Date;

public class AtendimentoDAOImpl extends AbstractDAOImpl<Atendimento, Long> implements AtendimentoDAO {
    public AtendimentoDAOImpl(EntityManagerFactory emf) {
        super(Atendimento.class, emf);
    }

    @Override
    public Atendimento findByData(Date data) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {
            TypedQuery<Atendimento> query = em.createQuery("SELECT a FROM Atendimento a WHERE a.data = :data", Atendimento.class);
            query.setParameter("data", data);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaDawException("Ocorreu um erro ao tentar encontrar o atendimento pela localidade.", e);
        }
    }
    public void deleteByData(Date data) throws PersistenciaDawException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Atendimento a WHERE a.data = :data");
            query.setParameter("data", data);
            int deletedCount = query.executeUpdate();

            em.getTransaction().commit();

            if (deletedCount == 0) {
                throw new PersistenciaDawException("Nenhum atendimento encontrado com a data: " + data);
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaDawException("Ocorreu um erro ao tentar deletar o atendimento do sistema.", e);
        } finally {
            em.close();
        }
    }
}
