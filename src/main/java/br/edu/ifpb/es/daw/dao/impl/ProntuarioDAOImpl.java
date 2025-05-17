package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProntuarioDAO;
import br.edu.ifpb.es.daw.entities.Prontuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class ProntuarioDAOImpl extends AbstractDAOImpl<Prontuario, Long> implements ProntuarioDAO {
    public ProntuarioDAOImpl(EntityManagerFactory emf) {
        super(Prontuario.class, emf);
    }

    @Override
    public Prontuario findById(Long id) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {
            TypedQuery<Prontuario> query = em.createQuery("SELECT a FROM Prontuario a WHERE a.id = :id", Prontuario.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaDawException("Ocorreu um erro ao tentar encontrar o prontuário a partir do identificador único.", e);
        }
    }
    @Override
    public Prontuario deleteById(Long id) throws PersistenciaDawException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Prontuario prontuario = em.find(Prontuario.class, id);
            if(prontuario != null){
                em.remove(prontuario);
            } else {
                throw  new PersistenciaDawException("Prontuário não foi encontrado com ID: " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaDawException("Ocorreu um erro ao tentar deletar o prontuário!", e);
        } finally {
            em.close();
        }
        return null;
    }
}
