package br.edu.ifpb.es.bdII.service;

import br.edu.ifpb.es.bdII.entities.Prontuario;
import br.edu.ifpb.es.bdII.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProntuarioService {

    @Autowired
    private ProntuarioRepository repository;

    public Prontuario salvar(Prontuario Prontuario) {
        return repository.save(Prontuario);
    }

    public List<Prontuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Prontuario> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Prontuario> buscarPorData(LocalDateTime data) {
        return repository.findByDataRegistro(data);
    }

    public void deletarPorId(String id) {
        repository.deleteById(id);
    }

    public void deletarPorData(LocalDateTime data) {
        repository.deleteByDataRegistro(data);
    }
}
