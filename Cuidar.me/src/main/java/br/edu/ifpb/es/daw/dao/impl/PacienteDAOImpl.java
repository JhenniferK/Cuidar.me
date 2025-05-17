package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PacienteDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class PacienteDAOImpl extends AbstractDAOImpl<Paciente, Long> implements PacienteDAO {
    public PacienteDAOImpl(EntityManagerFactory emf) {
        super(Paciente.class, emf);
    }

    @Override
    public Paciente findByCPF(Long cpf) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {
            TypedQuery<Paciente> query = em.createQuery("SELECT a FROM Paciente a WHERE a.cpf = :cpf", Paciente.class);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaDawException("Ocorreu um erro ao tentar encontrar o paciente através do cpf.", e);
        }
    }
    public boolean deleteByCPF(Long cpf) throws PersistenciaDawException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM Paciente p WHERE p.cpf = :cpf");
            query.setParameter("cpf", cpf);
            int deletedCount = query.executeUpdate();

            em.getTransaction().commit();

            return deletedCount > 0;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaDawException("Ocorreu um erro ao tentar deletar o Paciente do sistema", e);
        } finally {
            em.close();
        }
    }
}
