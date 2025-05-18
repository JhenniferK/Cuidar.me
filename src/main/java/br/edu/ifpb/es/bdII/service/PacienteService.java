package br.edu.ifpb.es.bdII.service;

import br.edu.ifpb.es.bdII.entities.Paciente;
import br.edu.ifpb.es.bdII.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Optional<Paciente> buscarPorCpf(Long cpf) {
        return repository.findByCpf(cpf);
    }

    public void deletarPorId(String id) {
        repository.deleteById(id);
    }

    public void deletarPorCpf(Long cpf) {
        repository.deleteByCpf(cpf);
    }
}
