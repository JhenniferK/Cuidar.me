package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PagamentoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.Pagamento;
import jakarta.persistence.*;

public class PagamentoDAOImpl extends AbstractDAOImpl<Pagamento, Long> implements PagamentoDAO {
    public PagamentoDAOImpl(EntityManagerFactory emf) {
        super(Pagamento.class, emf);
    }

    @Override
    public Pagamento findByStatus(boolean status) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {
            TypedQuery<Pagamento> query = em.createQuery("SELECT a FROM Pagamento a WHERE a.status = :status", Pagamento.class);
            query.setParameter("status", status);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaDawException("Ocorreu um erro ao tentar encontrar o pagamento através do status.", e);
        }
    }
    public void deleteByStatus(boolean status) throws PersistenciaDawException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("delete from Pagamento a where a.status = :status");
            query.setParameter("status", status);
            int deletedCount = query.executeUpdate();

            em.getTransaction().commit();
            if (deletedCount == 0) {
                throw new PersistenciaDawException("Nenhum pagamento encontrado com o status: " + status);
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenciaDawException("Ocorreu um erro ao tentar deletar o pagamento com o status: " + status, e);
        } finally {
            em.close();
        }
    }
}
