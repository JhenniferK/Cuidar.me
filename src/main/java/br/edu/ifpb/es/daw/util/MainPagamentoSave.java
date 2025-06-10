package br.edu.ifpb.es.daw.util;

import br.edu.ifpb.es.daw.dao.PagamentoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.PagamentoDAOImpl;
import br.edu.ifpb.es.daw.entities.Metodo;
import br.edu.ifpb.es.daw.entities.Pagamento;
import br.edu.ifpb.es.daw.entities.StatusPagamento;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class MainPagamentoSave {
    public static void main(String[] args) throws PersistenciaDawException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw");
        PagamentoDAO pagamentoDAO = new PagamentoDAOImpl(emf);
        Pagamento pagamento = new Pagamento();

        pagamento.setValor(234);
        pagamento.setMetodo(Metodo.ESPECIE);
        pagamento.setStatusPagamento(StatusPagamento.PAGO);
        LocalDateTime localDateTime = LocalDateTime.of(2025, 4, 3, 14, 30);
        pagamento.setData(localDateTime);

        System.out.println(pagamento);
        pagamentoDAO.save(pagamento);

    }
}
