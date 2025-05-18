package br.edu.ifpb.es.bdII.service;

import br.edu.ifpb.es.bdII.entities.Pagamento;
import br.edu.ifpb.es.bdII.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    public Pagamento salvar(Pagamento Pagamento) {
        return repository.save(Pagamento);
    }

    public List<Pagamento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pagamento> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void deletarPorId(String id) {
        repository.deleteById(id);
    }
}
