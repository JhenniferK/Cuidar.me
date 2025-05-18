package br.edu.ifpb.es.bdII.service;

import br.edu.ifpb.es.bdII.entities.Atendimento;
import br.edu.ifpb.es.bdII.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    public Atendimento salvar(Atendimento atendimento) {
        return repository.save(atendimento);
    }

    public List<Atendimento> listarTodos() {
        return repository.findAll();
    }

    public Optional<Atendimento> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Atendimento> buscarPorData(LocalDateTime data) {
        return repository.findByData(data);
    }

    public void deletarPorId(String id) {
        repository.deleteById(id);
    }

    public void deletarPorData(LocalDateTime data) {
        repository.deleteByData(data);
    }
}
