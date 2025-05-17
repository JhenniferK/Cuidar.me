package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PsicologoDAO;
import br.edu.ifpb.es.daw.entities.Psicologo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class PsicologoDAOImpl extends AbstractDAOImpl<Psicologo, Long> implements PsicologoDAO {
    public PsicologoDAOImpl (EntityManagerFactory emf){
        super(Psicologo.class, emf);
    }

    @Override
    public Psicologo findByEmail(String email) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {
            TypedQuery<Psicologo> query = em.createQuery("SELECT p FROM Psicologo p WHERE p.email = :email", Psicologo.class);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (Exception e){
            e.printStackTrace();
            throw new PersistenciaDawException("Ocorreu um erro ao tentar encontrar o psicólogo por email!", e);
        }
    }
    public void deleteByEmail(String email) throws  PersistenciaDawException{
        if(email == null || email.isEmpty()){
            throw  new PersistenciaDawException("O email está nulo ou vazio");
        }
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            Query query = em.createQuery("Delete from Psicologo p where p.email = :email");
            query.setParameter("email", email);
            int deleteCount = query.executeUpdate();

            em.getTransaction().commit();
            if (deleteCount == 0) {
                throw new PersistenciaDawException("Nenhum psicólogo encontrado com o email informado: "+ email);
            }
        } catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new PersistenciaDawException("Ocorreu um erro ao tentar deletar o psicólogo com o email informado!" + email, e);
        } finally {
            em.close();
        }
    }
}
