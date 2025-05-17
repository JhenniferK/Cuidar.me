package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.DawException;
import br.edu.ifpb.es.daw.dao.PagamentoDAO;
import br.edu.ifpb.es.daw.dao.impl.PagamentoDAOImpl;
import br.edu.ifpb.es.daw.entities.Pagamento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPagamentoDeleteAll {
    public static void main(String[] args) throws DawException {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){
            PagamentoDAO pagamentoDAO = new PagamentoDAOImpl(emf);
            List<Pagamento> pagamentos = pagamentoDAO.getAll();
            for(Pagamento pagamento : pagamentos){
                pagamentoDAO.delete(pagamento.getId());
            }
        }
    }
}
