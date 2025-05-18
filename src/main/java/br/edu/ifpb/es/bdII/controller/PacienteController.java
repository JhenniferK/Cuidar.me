package br.edu.ifpb.es.bdII.controller;

import br.edu.ifpb.es.bdII.entities.Paciente;
import br.edu.ifpb.es.bdII.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public Paciente criar(@RequestBody Paciente paciente) {
        return service.salvar(paciente);
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/cpf")
    public Optional<Paciente> buscarPorCpf(@RequestParam Long cpf) {
        return service.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
    }

    @DeleteMapping("/cpf")
    public void deletarPorCpf(@RequestParam Long cpf) {
        service.deletarPorCpf(cpf);
    }
}
